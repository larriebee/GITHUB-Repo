package com.netbuilder.nblibrary.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.nblibrary.businessParameters.BusinessParameters;
import com.netbuilder.nblibrary.domain.Borrower;
import com.netbuilder.nblibrary.domain.Item;
import com.netbuilder.nblibrary.domain.Loan;
import com.netbuilder.nblibrary.service.BorrowerServiceTemplate;
import com.netbuilder.nblibrary.service.ItemServiceTemplate;
import com.netbuilder.nblibrary.service.LoanServiceTemplate;

@Controller
@SessionAttributes({ "borrower", "item", "loan" })
public class MainController {

	@Autowired
	private BorrowerServiceTemplate borrowerService;

	@Autowired
	private ItemServiceTemplate itemService;

	@Autowired
	private LoanServiceTemplate loanService;

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String homePage(Model model) {

		checkOverdue();

		return "index";
	}

	@RequestMapping(value = "/aboutUs.html", method = RequestMethod.GET)
	public String aboutUsPage(Model model) {

		return "aboutUs";
	}

	/*
	 * Borrower Mappings
	 */

	//Need to add javascript to validate the form entries
	@RequestMapping(value="/addBorrower.html", method=RequestMethod.GET)
	public ModelAndView newBorrowerForm(@RequestParam(value="errorMessage", required=false) String errorMessage)
	{
		ModelAndView mav = new ModelAndView("addBorrower");
	    Borrower borrower = new Borrower();
	    mav.getModelMap().put("borrower", borrower);
	    return mav;
	}
	
	@RequestMapping(value="/addBorrower.html", method=RequestMethod.POST)
	public ModelAndView addBorrower(@ModelAttribute("borrower") Borrower borrower, BindingResult result)
	{
		ModelAndView mav = new ModelAndView("addBorrower");
		
		if(borrowerService.retrieveByEmail(borrower.getEmail()).isEmpty())
		{
			mav.getModelMap().put("errorMessage", "The new Borrower was successfully added");
			borrowerService.add(borrower);
		} else {
			mav.getModelMap().put("errorMessage", "There is already a Borrower with that Email Address");
		}
		return mav;
	}

	@RequestMapping(value = "/removeBorrower.html", method = RequestMethod.GET)
	public String removeBorrowerForm(
			@RequestParam(value = "errorMessage", required = false) String errorMessage,
			Model model) {
		model.addAttribute("errorMessage", errorMessage);
		return "removeBorrower";
	}

	@RequestMapping(value = "/removeBorrowerSubmission.html", method = RequestMethod.GET)
	public String removeBorrower(
			@RequestParam(value = "email", required = true) String email,
			Model model) {
		List<Borrower> borrowers = borrowerService.retrieveByEmail(email);

		if (borrowers.size() > 1) {
			model.addAttribute("errorMessage",
					"More than one borrower with that email");

			return "removeBorrower";
		} else if (borrowers.isEmpty()) {
			model.addAttribute("errorMessage", "Borrower does not exist");

			return "removeBorrower";
		} else if (!loanService.retrieveOpenLoansForBorrower(
				borrowers.get(0).getBorrowerId()).isEmpty()) {
			model.addAttribute("errorMessage",
					"The Borrower still has open loans, return items before continuing");

			return "removeBorrower";
		} else {
			borrowerService.remove(borrowers.get(0));

			model.addAttribute("errorMessage", "The Borrower has been removed");

			return "removeBorrower";
		}
	}

	@RequestMapping(value = "/updateBorrower.html", method = RequestMethod.GET)
	public String updateBorrowerForm(
			@RequestParam(value = "errorMessage", required = false) String errorMessage,
			Model model) {
		return "updateBorrower";
	}

	@RequestMapping(value = "/updateBorrowerSubmission.html", method = RequestMethod.GET)
	public String updateBorrowerSubmission(
			@RequestParam(value = "email", required = true) String email,
			Model model) {
		List<Borrower> borrowers = borrowerService.retrieveByEmail(email);

		if (borrowers.size() > 1) {
			model.addAttribute("errorMessage",
					"More than one borrower with that email");

			return "updateBorrower";
		} else if (borrowers.isEmpty()) {
			model.addAttribute("errorMessage", "Borrower does not exist");

			return "updateBorrower";
		} else {
			model.addAttribute("borrower", borrowers.get(0));
			return "updateABorrower";
		}
	}

	// Need to implement JavaScript to validate the form entries
	@RequestMapping(value = "/updateBorrower.html", method = RequestMethod.POST)
	public String updateBorrower(@ModelAttribute("borrower") Borrower borrower,
			BindingResult result, Model model) {
		borrowerService.update(borrower);

		model.addAttribute("errorMessage", "The Borrower has been updated");

		return "updateBorrower";
	}

	@RequestMapping(value = "/listBorrowers.html", method = RequestMethod.GET)
	public String listBorrowers(Model model) {
		List<Borrower> borrowers = borrowerService.retrieveAll();
		model.addAttribute("borrowers", borrowers);

		return "listBorrowers";
	}

	/*
	 * Item Mappings
	 */

	@RequestMapping(value = "/addItem.html", method = RequestMethod.GET)
	public ModelAndView newItemForm() {
		ModelAndView mav = new ModelAndView("addItem");
		Item item = new Item();
		mav.getModelMap().put("item", item);
		return mav;
	}

	// Need to implement JavaScript to validate the form entries
	@RequestMapping(value = "/addItem.html", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item,
			BindingResult result) {
		item.setLoanable(true);
		itemService.add(item);

		return "redirect:/index.html";
	}

	@RequestMapping(value = "/removeItem.html", method = RequestMethod.GET)
	public String removeItemForm(
			@RequestParam(value = "errorMessage", required = false) String errorMessage,
			Model model) {
		model.addAttribute("errorMessage", errorMessage);
		return "removeItem";
	}

	@RequestMapping(value = "/removeItemSubmission.html", method = RequestMethod.GET)
	public String removeItem(
			@RequestParam(value = "title", required = true) String title,
			Model model) {
		List<Item> items = itemService.retrieveByTitle(title);

		if (items.size() > 1) {
			model.addAttribute("errorMessage",
					"More than one item with that title");

			return "removeItem";
		} else if (items.isEmpty()) {
			model.addAttribute("errorMessage", "Item does not exist");

			return "removeItem";
		} else if (!items.get(0).isLoanable()) {
			model.addAttribute("errorMessage",
					"The item is still on loan, return the item before continuing");

			return "removeItem";
		} else {
			itemService.remove(items.get(0));

			model.addAttribute("errorMessage", "The item has been removed");

			return "removeItem";
		}
	}

	@RequestMapping(value = "/updateItem.html", method = RequestMethod.GET)
	public String updateItemForm(
			@RequestParam(value = "errorMessage", required = false) String errorMessage,
			Model model) {

		return "updateItem";
	}

	@RequestMapping(value = "/updateItemSubmission.html", method = RequestMethod.GET)
	public String updateItemSubmission(
			@RequestParam(value = "title", required = true) String title,
			Model model) {
		List<Item> items = itemService.retrieveByTitle(title);

		if (items.size() > 1) {
			model.addAttribute("errorMessage",
					"More than one item with that email");

			return "updateItem";
		} else if (items.isEmpty()) {
			model.addAttribute("errorMessage", "Item does not exist");

			return "updateItem";
		} else {
			model.addAttribute("item", items.get(0));
			return "updateAnItem";
		}
	}

	// Need to implement JavaScript to validate the form entries
	@RequestMapping(value = "/updateItem.html", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute("item") Item item,
			BindingResult result, Model model) {
		itemService.update(item);

		model.addAttribute("errorMessage", "The Item has been updated");

		return "updateItem";
	}

	@RequestMapping(value = "/listItems.html", method = RequestMethod.GET)
	public String listItems(Model model) {
		List<Item> items = itemService.retrieveAll();
		model.addAttribute("items", items);

		return "listItems";
	}

	/*
	 * Loan Mappings
	 */

	@RequestMapping(value = "/addLoan.html", method = RequestMethod.GET)
	public ModelAndView addLoan(
			@RequestParam(value = "errorMessage", required = false) String errorMessage) {
		ModelAndView mav = new ModelAndView("addLoanSearchBorrowers");
		return mav;
	}

	@RequestMapping(value = "/addLoanItem.html", method = RequestMethod.GET)
	public ModelAndView addLoanItem(
			@RequestParam(value = "errorMessage", required = false) String errorMessage,
			@RequestParam(value = "email", required = true) String email) {
		ModelAndView mav = new ModelAndView("addLoanSearchBorrowers");

		List<Borrower> borrowers = borrowerService.retrieveByEmail(email);

		if (borrowers.size() > 1) {
			mav.getModelMap().put("errorMessage",
					"More than one borrower with that email");

		} else if (borrowers.isEmpty()) {
			mav.getModelMap().put("errorMessage", "Borrower does not exist");

		} else if (borrowers.get(0).isBlacklisted()) {
			mav.getModelMap().put("errorMessage", "Borrower is Blacklisted");

		} else if (loanService.retrieveOpenLoansForBorrower(
				borrowers.get(0).getBorrowerId()).size() >= BusinessParameters.LOAN_LIMIT) {
			mav.getModelMap().put("errorMessage",
					"Borrower currently has too many items out on loan");

		} else if (!loanService.retrieveOverdueLoansForBorrower(
				borrowers.get(0).getBorrowerId()).isEmpty()) {
			mav.getModelMap().put("errorMessage",
					"Borrower currently has overdue loans");

		} else {
			mav = new ModelAndView("addLoanSearchItems");
			mav.getModelMap().put("borrower", borrowers.get(0));
		}

		return mav;
	}

	@RequestMapping(value = "/addLoanConfirmation.html", method = RequestMethod.GET)
	public ModelAndView addLoanConfirmations(
			@RequestParam(value = "title", required = true) String title,
			@ModelAttribute("borrower") Borrower borrower, BindingResult result) {
		ModelAndView mav = new ModelAndView("addLoanSearchItems");

		List<Item> items = itemService.retrieveByTitle(title);

		if (items.size() > 1) {
			mav.getModelMap().put("errorMessage",
					"More than one item with that email");

		} else if (items.isEmpty()) {
			mav.getModelMap().put("errorMessage", "Item does not exist");

		} else if (!itemService.isLoanable(items.get(0).getItemId())) {
			mav.getModelMap().put("errorMessage", "Item is not loanable");

		} else {
			mav = new ModelAndView("addLoanSubmission");
			mav.getModelMap().put("borrower", borrower);
			mav.getModelMap().put("item", items.get(0));
			mav.getModelMap().put("loan", new Loan());
		}

		return mav;
	}

	@RequestMapping(value = "/addLoanSubmission.html", method = RequestMethod.POST)
	public String addLoan(@ModelAttribute("loan") Loan loan,
			BindingResult result, Model model) {
		loanService.add(loan);
		itemService.toggleLoanable(loan.getItemId());

		model.addAttribute("errorMessage", "The Loan has been created");

		return "addLoanSearchBorrowers";
	}

	@RequestMapping(value = "/removeLoan.html", method = RequestMethod.GET)
	public ModelAndView removeLoanForm(
			@RequestParam(value = "errorMessage", required = false) String errorMessage) {
		ModelAndView mav = new ModelAndView("removeLoan");
		return mav;
	}

	@RequestMapping(value = "/removeLoanBorrower.html", method = RequestMethod.GET)
	public ModelAndView removeLoanBorrower(
			@RequestParam(value = "email", required = true) String email) {
		ModelAndView mav = new ModelAndView("removeLoan");

		List<Borrower> borrowers = borrowerService.retrieveByEmail(email);

		if (borrowers.size() > 1) {
			mav.getModelMap().put("errorMessage",
					"More than one borrower with that email");

		} else if (borrowers.isEmpty()) {
			mav.getModelMap().put("errorMessage", "Borrower does not exist");

		} else {
			mav = new ModelAndView("removeLoanBorrower");
			List<Loan> loans = loanService
					.retrieveOpenLoansForBorrower(borrowers.get(0)
							.getBorrowerId());
			mav.getModelMap().put("loans", loans);
			mav.getModelMap().put("borrower", borrowers.get(0));

			// for each loan in loans, get the item and them put them into a
			// list
			List<Item> items = new ArrayList<Item>();

			for (Loan loan : loans) {
				Item item = itemService.retrieveById(loan.getItemId());
				items.add(item);
			}

			mav.getModelMap().put("items", items);

		}

		return mav;
	}

	@RequestMapping(value = "/removeLoanSubmission.html", method = RequestMethod.POST)
	public ModelAndView removeLoan(
			@RequestParam(value = "returnedLoans", required = true) String[] returnedLoans) {
		ModelAndView mav = new ModelAndView("removeLoan");

		String returnedLoanIds = "";

		for (String loanId : returnedLoans) {
			Loan loan = loanService.retrieveById(Integer.parseInt(loanId));
			returnedLoanIds = returnedLoanIds + " " + loanId;
			itemService.toggleLoanable(loan.getItemId());
			loanService.remove(loan);
		}

		mav.getModelMap().put("errorMessage",
				"The following loan(s) have been returned: " + returnedLoanIds);

		return mav;
	}

	@RequestMapping(value="/listLoans.html", method=RequestMethod.GET)
	public ModelAndView listLoans()
	{
		ModelAndView mav = new ModelAndView("listLoans");
		
		List<Loan> loans = loanService.retrieveAll();
		mav.getModelMap().put("loans", loans);
		
		List<Item> items = new ArrayList<Item>();
		List<Borrower> borrowers = new ArrayList<Borrower>();
		
		for(Loan loan : loans)
		{
			Item item = itemService.retrieveById(loan.getItemId());
			items.add(item);
			Borrower borrower = borrowerService.retrieveById(loan.getBorrowerId());
			borrowers.add(borrower);
		}
		
		mav.getModelMap().put("items", items);
		mav.getModelMap().put("borrowers", borrowers);
		
		return mav;
	}

	@RequestMapping(value = "/listOverdueLoans.html", method = RequestMethod.GET)
	public String listOverudeLoans(Model model) {
		List<Loan> loans = loanService.retrieveOverdueLoans();
		model.addAttribute("loans", loans);

		return "listOverdueLoans";
	}

	@RequestMapping(value = "/get_email_list", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	List<String> getEmailList(@RequestParam("term") String query) {

		List<String> listOfBorrowers = new ArrayList<String>();
		List<Borrower> borrowers = borrowerService.retrieveAll();
		Iterator<Borrower> iterator = borrowers.iterator();
		query = query.toUpperCase();

		while (iterator.hasNext()) {
			Borrower borrower = iterator.next();
			if (borrower.getEmail().toUpperCase().startsWith(query)) {
				listOfBorrowers.add(borrower.getEmail());
			}

		}

		return listOfBorrowers;
	}

	@RequestMapping(value = "/get_title_list", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	List<String> getTitleList(@RequestParam("term") String query) {

		List<String> listOfTitles = new ArrayList<String>();
		List<Item> items = itemService.retrieveAll();
		Iterator<Item> iterator = items.iterator();

		query = query.toUpperCase();

		while (iterator.hasNext()) {
			Item item = iterator.next();
			if (item.getTitle().toUpperCase().startsWith(query)) {
				listOfTitles.add(item.getTitle());
			}

		}

		System.out.println(listOfTitles);

		return listOfTitles;
	}

	// checks whether an item has gone overdue, if so, mark as overdue and add a
	// strike to the borrower
	// if borrower has reached the strike limit, mark them as blacklisted
	// Should be called at midnight everyday
	public void checkOverdue() {
		List<Loan> loans = loanService.retrieveAll();

		for (Loan loan : loans) {
			if ((!loan.isOverdue())
					&& loan.getEndDate().before(
							loanService.calculateCurrentDate())) {
				Borrower borrower = borrowerService.retrieveById(loan
						.getBorrowerId());
				int newBorrowerStrikes = borrower.getStrikes() + 1;
				borrower.setStrikes(newBorrowerStrikes);

				if (newBorrowerStrikes >= BusinessParameters.STRIKE_LIMIT) {
					borrower.setBlacklisted(true);
				}

				borrowerService.update(borrower);

				loan.setOverdue(true);
				loanService.update(loan);

			}
		}
	}

}

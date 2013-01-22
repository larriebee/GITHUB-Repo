package com.netbuilder.nblibrary.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netbuilder.nblibrary.businessParameters.BusinessParameters;
import com.netbuilder.nblibrary.dao.LoanDAOTemplate;
import com.netbuilder.nblibrary.domain.Loan;

@Service
public class LoanService implements LoanServiceTemplate
{
	@Autowired
    private LoanDAOTemplate loanDAO;
	
	@Transactional
    public List<Loan> retrieveAll()
    {
    	return loanDAO.retrieveAll();
    }
    
	@Transactional
    public void update(Loan loan)
    {
    	loanDAO.update(loan);
    }
	
	@Transactional
    public Loan retrieveById(int loanId)
    {
    	return loanDAO.retrieveById(loanId);
    }
    
	@Transactional
    public void remove(Loan loan)
    {
        loanDAO.remove(loan);
    }
    
	@Transactional
    public void add(Loan loan)
    {
		loan.setStartDate(calculateCurrentDate());
		loan.setEndDate(calculateEndDate());
		loan.setOpen(true);
		loan.setOverdue(false);
        loanDAO.add(loan);
    }
    
    public Date calculateCurrentDate()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTime().getTime());
        
        return date;
    }
    
    public Date calculateEndDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, BusinessParameters.LOAN_LENGTH);
        Date date = new Date(calendar.getTime().getTime());
        
        return date;
    }
    
    @Transactional
    public List<Loan> retrieveOpenLoansForBorrower(int borrowerId)
    {
    	return loanDAO.retrieveOpenLoansForBorrower(borrowerId);
    }
    
    @Transactional
    public List<Loan> retrieveOverdueLoansForBorrower(int borrowerId) 
    {
    	return loanDAO.retrieveOverdueLoansForBorrower(borrowerId);
    }
    
    @Transactional
    public Loan retrieveLoanForItem(int itemId)
    {
    	return loanDAO.retrieveLoanForItem(itemId);
    }
    
    @Transactional
    public List<Loan> retrieveOverdueLoans()
    {
    	return loanDAO.retrieveOverdueLoans();
    }
 
}

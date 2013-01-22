package com.netbuilder.nblibrary.dao;

import java.util.List;

import com.netbuilder.nblibrary.domain.Loan;

public interface LoanDAOTemplate extends DAOTemplate <Loan> {

	public List<Loan> retrieveOverdueLoans();
	
	public List<Loan> retrieveOpenLoansForBorrower(int borrowerId);
    
    public List<Loan> retrieveOverdueLoansForBorrower(int borrowerId);
    
    public Loan retrieveLoanForItem(int itemId);
	
}

package com.netbuilder.nblibrary.service;

import java.util.Date;
import java.util.List;

import com.netbuilder.nblibrary.domain.Loan;

public interface LoanServiceTemplate extends ServiceTemplate <Loan> {
	
	public Date calculateCurrentDate();
    
    public Date calculateEndDate();
    
    public List<Loan> retrieveOverdueLoans();
    
    public List<Loan> retrieveOpenLoansForBorrower(int borrowerId);
    
    public List<Loan> retrieveOverdueLoansForBorrower(int borrowerId);
    
    public Loan retrieveLoanForItem(int itemId);
    	
}

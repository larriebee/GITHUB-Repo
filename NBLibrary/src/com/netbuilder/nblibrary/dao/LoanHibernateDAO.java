package com.netbuilder.nblibrary.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netbuilder.nblibrary.domain.Loan;

@Repository
public class LoanHibernateDAO implements LoanDAOTemplate
{
	@Autowired
	private SessionFactory sessionFactory;
	
    public List<Loan> retrieveAll() 
    {
    	return sessionFactory.getCurrentSession().createQuery("from Loan").list();
    }
    
    public void update(Loan loan) 
    {
    	sessionFactory.getCurrentSession().merge(loan);
    }
    
    public List<Loan> retrieveOverdueLoans()
    {
    	return sessionFactory.getCurrentSession().createQuery("select l from Loan l where l.overdue = '1'").list();
    	
    }
    
    public Loan retrieveById(int loanId) 
    {
    	return (Loan) sessionFactory.getCurrentSession().get(Loan.class, loanId);
    }
    
    public void remove(Loan loan)
    {
    	sessionFactory.getCurrentSession().delete(loan);
    }
    
    public void add(Loan loan)
    {
    	sessionFactory.getCurrentSession().save(loan);
    }
    
    public List<Loan> retrieveOpenLoansForBorrower(int borrowerId)
    {
    	return sessionFactory.getCurrentSession().createQuery("select l from Loan l where l.borrowerId = '" + borrowerId + "' and l.open = '1'").list();
    }
    
    public List<Loan> retrieveOverdueLoansForBorrower(int borrowerId)
    {
    	return sessionFactory.getCurrentSession().createQuery("select l from Loan l where l.borrowerId = '" + borrowerId + "' and l.overdue = 1").list();
    }
    
    
    public Loan retrieveLoanForItem(int itemId)
    {
    	return (Loan) sessionFactory.getCurrentSession().createQuery("select l from Loan l where l.itemId = '" + itemId + "'").list().get(0);
    }
    
}
package com.netbuilder.nblibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netbuilder.nblibrary.dao.BorrowerDAOTemplate;
import com.netbuilder.nblibrary.domain.Borrower;

@Service
public class BorrowerService implements BorrowerServiceTemplate
{
	@Autowired
    private BorrowerDAOTemplate borrowerDAO;
    
	@Transactional
    public void add(Borrower borrower)
    {
    	borrowerDAO.add(borrower);
    }

    @Transactional
    public List<Borrower> retrieveAll() 
    {
        return borrowerDAO.retrieveAll();
    }
    
    @Transactional
    public Borrower retrieveById(int borrowerId) 
    {
    	return borrowerDAO.retrieveById(borrowerId);
    }

    @Transactional
    public void remove(Borrower borrower) 
    {
    	borrowerDAO.remove(borrower);
    }
    
    @Transactional
    public List<Borrower> retrieveByEmail(String email)
    {
        return borrowerDAO.retrieveByEmail(email);
    }

    @Transactional
    public void update(Borrower borrower)
    {
        borrowerDAO.update(borrower);
    }

}
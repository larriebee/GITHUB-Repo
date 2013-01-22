package com.netbuilder.nblibrary.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netbuilder.nblibrary.domain.Borrower;

@Repository
public class BorrowerHibernateDAO implements BorrowerDAOTemplate
{
	@Autowired
	private SessionFactory sessionFactory;
	
    public List<Borrower> retrieveAll() 
    {
    	return sessionFactory.getCurrentSession().createQuery("from Borrower").list();
    }

    public Borrower retrieveById(int borrowerId) 
    {
    	return (Borrower) sessionFactory.getCurrentSession().get(Borrower.class, borrowerId);
    }

    /*
     * Updates a given borrower in the database after the parameters have been changes i.e. borrower.setName("Roy");
     */
    public void update(Borrower borrower) 
    {
    	sessionFactory.getCurrentSession().merge(borrower);
    }
    
    public void add(Borrower borrower)
    {
    	sessionFactory.getCurrentSession().save(borrower);
    }

    public void remove(Borrower borrower) 
    {
        sessionFactory.getCurrentSession().delete(borrower);
    }

    public List<Borrower> retrieveByEmail(String email) 
    {
    	return (List<Borrower>) sessionFactory.getCurrentSession().createQuery("select b from Borrower b where b.email = '" + email + "'").list();
    }
    
}

package com.netbuilder.nblibrary.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netbuilder.nblibrary.domain.Item;
import com.netbuilder.nblibrary.domain.Loan;

@Repository
public class ItemHibernateDAO implements ItemDAOTemplate
{
	@Autowired
	private SessionFactory sessionFactory;
	
    public List<Item> retrieveAll() 
    {
        return sessionFactory.getCurrentSession().createQuery("from Item").list();
    }
    
    /*
     * Updates a given item in the database after the parameters have been changes i.e. borrower.setName("Roy");
     */
    public void update(Item item) 
    {
    	sessionFactory.getCurrentSession().merge(item);
    }

    public Item retrieveById(int itemId) 
    {
    	return (Item) sessionFactory.getCurrentSession().get(Item.class, itemId);
    }
    
    public void remove(Item item) 
    {
    	sessionFactory.getCurrentSession().delete(item);
    }
    
    public void add(Item item)
    {
    	sessionFactory.getCurrentSession().save(item);
    }

    public List<Item> retrieveByTitle(String title) 
    {
    	return sessionFactory.getCurrentSession().createQuery("select i from Item i where i.title = '" + title + "'").list();
    }
    
}

package com.netbuilder.nblibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netbuilder.nblibrary.dao.ItemDAOTemplate;
import com.netbuilder.nblibrary.domain.Item;
 

@Service
public class ItemService implements ItemServiceTemplate
{
	@Autowired
    private ItemDAOTemplate itemDAO;
	
	@Transactional
    public List<Item> retrieveAll()
    {
    	return itemDAO.retrieveAll();
    }
    
	@Transactional
    public void update(Item item)
    {
    	itemDAO.update(item);
    }
    
	@Transactional
    public Item retrieveById(int itemId)
    {
        return itemDAO.retrieveById(itemId);
    }
    
	@Transactional
    public void remove(Item item)
    {
		itemDAO.remove(item);
    }
	
	@Transactional
    public void add(Item item)
    {
        itemDAO.add(item);
    }
	
	@Transactional
	public boolean isLoanable(int itemId)
	{
		Item item = retrieveById(itemId);
		
		return item.isLoanable();
	}

	@Transactional
    public List<Item> retrieveByTitle(String item)
    {
		return itemDAO.retrieveByTitle(item);
    }
	
	@Transactional
	public void toggleLoanable(int itemId)
	{
		Item item = retrieveById(itemId);
		
		if (item.isLoanable()){
			item.setLoanable(false);
		}else{
			item.setLoanable(true);
		}
		update(item);
	}
	
}
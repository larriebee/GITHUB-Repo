package com.netbuilder.nblibrary.service;

import java.util.List;

import com.netbuilder.nblibrary.domain.Item;

public interface ItemServiceTemplate extends ServiceTemplate <Item> {
	
	public boolean isLoanable(int itemId);

    public List<Item> retrieveByTitle(String search);
    
    public void toggleLoanable(int itemId);
	
}

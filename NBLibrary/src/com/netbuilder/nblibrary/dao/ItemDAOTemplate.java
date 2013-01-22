package com.netbuilder.nblibrary.dao;

import java.util.List;

import com.netbuilder.nblibrary.domain.Item;

public interface ItemDAOTemplate extends DAOTemplate<Item>{
	
	public List<Item> retrieveByTitle(String search);

}

package com.netbuilder.nblibrary.dao;

import java.util.List;

public interface DAOTemplate <T> {
	public List<T> retrieveAll();
	public void add(T t);
	public void remove(T t);
	public T retrieveById(int id);
	public void update(T t);
}

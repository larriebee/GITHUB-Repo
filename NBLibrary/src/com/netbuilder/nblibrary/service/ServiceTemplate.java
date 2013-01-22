package com.netbuilder.nblibrary.service;

import java.util.List;

public interface ServiceTemplate <T> {
	public List<T> retrieveAll();
	public void add(T t);
	public void remove(T t);
	public T retrieveById(int id);
	public void update(T t);
}

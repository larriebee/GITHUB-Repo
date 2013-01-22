package com.netbuilder.nblibrary.dao;

import java.util.List;

import com.netbuilder.nblibrary.domain.Borrower;

public interface BorrowerDAOTemplate extends DAOTemplate<Borrower> {

    public List<Borrower> retrieveByEmail(String email);

}

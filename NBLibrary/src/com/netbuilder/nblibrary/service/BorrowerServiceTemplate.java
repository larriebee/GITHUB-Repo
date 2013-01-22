package com.netbuilder.nblibrary.service;

import java.util.List;

import com.netbuilder.nblibrary.domain.Borrower;

public interface BorrowerServiceTemplate extends ServiceTemplate <Borrower> {

    public List<Borrower> retrieveByEmail(String email);
}

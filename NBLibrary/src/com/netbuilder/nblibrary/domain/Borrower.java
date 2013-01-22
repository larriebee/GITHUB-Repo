package com.netbuilder.nblibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="borrower")
public class Borrower 
{
	@Id
	@Column(name="borrowerId")
	@GeneratedValue
    private int borrowerId;
	
	@Column(name="name")
    private String name;
	
	@Column(name="email")
    private String email;
	
	@Column(name="blacklisted")
    private boolean blacklisted;
	
	@Column(name="strikes")
    private int strikes;
	
	public Borrower(){}
	
    public Borrower(int borrowerId, String name, String email, int strikes, boolean blackListed)
    {    
        this.borrowerId = borrowerId;
        this.name = name;
        this.email = email;
        this.strikes = strikes;
        this.blacklisted = blackListed;
    }

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isBlacklisted() {
		return blacklisted;
	}

	public void setBlacklisted(boolean blacklisted) {
		this.blacklisted = blacklisted;
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}       
	
       

}

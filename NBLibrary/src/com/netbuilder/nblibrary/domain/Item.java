package com.netbuilder.nblibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item 
{
    @Id
    @Column(name="itemId")
    @GeneratedValue
	private int itemId;
    
    @Column(name="title")
    private String title;
    
    @Column(name="author")
    private String author;
    
    @Column(name="edition")
    private String edition;
    
    @Column(name="publishDate")
    private String publishDate;
    
    @Column(name="loanable")
    private boolean loanable;
    
    public Item(){}

    public Item(int itemId, String title, String author, String edition, String publishDate, boolean loanable) 
    {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.publishDate = publishDate;
        this.loanable = loanable;
    }

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isLoanable() {
		return loanable;
	}

	public void setLoanable(boolean loanable) {
		this.loanable = loanable;
	}
     
    

}
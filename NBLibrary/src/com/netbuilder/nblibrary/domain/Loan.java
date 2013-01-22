package com.netbuilder.nblibrary.domain;
 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class Loan 
{	
    @Id
    @Column(name="loanId")
    @GeneratedValue
	private int loanId;
    
    @Column(name="startDate")
    private Date startDate;
    
    @Column(name="endDate")
    private Date endDate;
    
    @Column(name="open")
    private boolean open;
    
    @Column(name="overdue")
    private boolean overdue;
    
    @Column(name="borrowerId")
    private int borrowerId;
    
    @Column(name="itemId")
    private int itemId;
    
    public Loan(){}
	
    public Loan(int loanId, Date startDate, Date endDate, boolean open, boolean overdue, int borrowerId, int itemId)
    { 
        this.loanId = loanId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.open = open;
        this.overdue = overdue;
        this.borrowerId = borrowerId;
        this.itemId = itemId;
    }

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

    

}

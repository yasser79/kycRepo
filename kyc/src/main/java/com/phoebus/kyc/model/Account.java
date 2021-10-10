package com.phoebus.kyc.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long accountId;
	
	private int accountNumber;
	
	@ManyToOne
    @JoinColumn(name = "customerId", nullable=false)
	@JsonManagedReference
	//@JsonIgnoreProperties("account")
	private Customer customer;
	
	public Account() {
	}
	

	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Account(long accountId, int accountNumber) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
	}
	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", customer=" + customer + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountId, accountNumber, customer);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountId, other.accountId) && accountNumber == other.accountNumber
				&& Objects.equals(customer, other.customer);
	}



}
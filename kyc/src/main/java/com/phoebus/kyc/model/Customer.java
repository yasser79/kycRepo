package com.phoebus.kyc.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long customerId;

	private String forename;

	private String surname;

	private Timestamp dob;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonBackReference
//	@JsonIgnoreProperties("customer")
	private List<Account> accounts;

	public Customer() {
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer(long customerId) {
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, dob, forename, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(dob, other.dob)
				&& Objects.equals(forename, other.forename) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", forename=" + forename + ", surname=" + surname + ", dob=" + dob
				+ "]";
	}



}
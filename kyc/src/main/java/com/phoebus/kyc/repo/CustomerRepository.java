package com.phoebus.kyc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoebus.kyc.model.Customer;

	public interface CustomerRepository extends JpaRepository<Customer, Long> {

	}


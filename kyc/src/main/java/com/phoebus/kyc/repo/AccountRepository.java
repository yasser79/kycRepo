package com.phoebus.kyc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoebus.kyc.model.Account;

	public interface AccountRepository extends JpaRepository<Account, Long> {

		List<Account> findByCustomerCustomerId(Long customerId);
	}


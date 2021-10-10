package com.phoebus.kyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phoebus.kyc.model.Account;
import com.phoebus.kyc.repo.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/customer/{customerId}/accounts")
    public List<Account> getAccountsByCustomer(@PathVariable(value = "customerId") Long customerId) {
        return accountRepository.findByCustomerCustomerId(customerId);
    }	
	
	@PostMapping("/account")
	public Account newAccount(@RequestBody Account newAccount) {
		return accountRepository.save(newAccount);
	}


}
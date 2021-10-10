package com.phoebus.kyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phoebus.kyc.model.Customer;
import com.phoebus.kyc.repo.CustomerRepository;

@RestController
class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;


	@PostMapping("/customer")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}
	
}
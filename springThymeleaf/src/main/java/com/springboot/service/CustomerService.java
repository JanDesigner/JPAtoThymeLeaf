package com.springboot.service;

import java.util.List;

import com.springboot.model.Customer;

public interface CustomerService {
	
	
	List<Customer> getCustomer();
	void AddCustomer(Customer customer);
	Customer getCustomerById(long id);
	void deleteCustomerById(long id);
}

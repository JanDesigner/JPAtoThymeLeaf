package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Customer;
import com.springboot.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomer() {
		
		return (List<Customer>) customerRepository.findAll();
		
	}

	@Override
	public void AddCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomerById(long id) {
		Customer customer = customerRepository.findById(id).get();
		return customer;
	}

	@Override
	public void deleteCustomerById(long id) {
		   customerRepository.deleteById(id);
		
	}
	
	

}

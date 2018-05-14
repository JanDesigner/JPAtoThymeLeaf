package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

}

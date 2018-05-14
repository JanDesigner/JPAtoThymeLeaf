package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Customer;
import com.springboot.service.CustomerService;


@Controller
public class JavaController {
	
    @Autowired
    CustomerService customerService;

    @RequestMapping(value ="/customer")
    public ModelAndView index() {
    	
    	ModelAndView model = new ModelAndView();
    	model.addObject("customers" , customerService.getCustomer());
    	model.setViewName("list");
        return model;
    }
    
    @RequestMapping(value = "/customerform")
    public ModelAndView getform() {
    	ModelAndView model = new ModelAndView();
    	Customer customer = new Customer();
    	model.addObject("customers" , customer);
    	model.setViewName("customerform");
    	return model;
    	
    }
    
    @RequestMapping(value = "/save")
    public ModelAndView saveCustomer(@ModelAttribute("customers")Customer customer) {
    	
    	customerService.AddCustomer(customer);
    	return new ModelAndView("redirect:/customer");
    }
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editCustomer(@PathVariable("id")long id ) {
    	ModelAndView model = new ModelAndView();
    	Customer customer = customerService.getCustomerById(id);
    	model.addObject("customers", customer);
    	model.setViewName("customerform");
    	return model;
    	
    }
    
    @RequestMapping(value ="/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable("id")long id) {
    	customerService.deleteCustomerById(id);
    	return new ModelAndView("redirect:/customer");
    }


} 

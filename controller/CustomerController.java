package com.demo.SalaryInfoApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SalaryInfoApi.model.Customer;
import com.demo.SalaryInfoApi.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
  
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("/save")
	public String saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
	@GetMapping("/searchCustomer/{custId}")
	public Customer getCustomer(@PathVariable int custId)
	{
		return service.getCustomer(custId);
	}
	
	@DeleteMapping("/deleteCustomer/{custId}")
	public List<Customer> deleteCustomer(@PathVariable int custId)
	{
		return service.removeCustomer(custId);
	}
}

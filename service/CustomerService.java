package com.demo.SalaryInfoApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SalaryInfoApi.dao.CustomerRepository;
import com.demo.SalaryInfoApi.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private PdfFileService pdfservice;
	
	public String saveCustomer(Customer customer)
	{
		custRepo.save(customer);
		pdfservice.pdfGenerate(customer);
		return "Customer added with Id " + customer.getCustId() + " and Interest Amount is " +
			    (customer.getSalary()*customer.getInterest())/100;
	}
	
	public Customer getCustomer(int custId)
	{
		Optional<Customer> optional = custRepo.findById(custId);
		Customer customer = null;
		if(optional.isPresent())
		{
			customer = optional.get();
			pdfservice.pdfGenerate(customer);
		} else
		  {
			throw new RuntimeException("Customer not found for id :: " + custId);
		  }
		return customer;
	}
	
	public List<Customer> removeCustomer(int custId)
	{
		custRepo.deleteById(custId);
		return custRepo.findAll();
	}
}
 
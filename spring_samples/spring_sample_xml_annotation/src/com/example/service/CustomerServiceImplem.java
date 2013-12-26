package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImplem implements CustomerService {
	
	private CustomerRepository custRepos;
	
	public CustomerServiceImplem() {}
	
	@Autowired
	public CustomerServiceImplem(CustomerRepository customerRepository) {
		System.out.println("using constructor injection. Heeeey hey heeeey!!!");
		this.custRepos = customerRepository;
	}
	
	public void setCustRepos(CustomerRepository custRepos) {
		System.out.println("using setter injection. Jahooooo!!! ");
		
		this.custRepos = custRepos;
	}

	public List<Customer> findAll() {
		return custRepos.findAll();
	}

}

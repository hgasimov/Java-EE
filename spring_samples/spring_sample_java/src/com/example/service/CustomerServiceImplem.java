package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

public class CustomerServiceImplem implements CustomerService {
	private CustomerRepository custRepos;	
	
	public CustomerServiceImplem() {}
	
	public CustomerServiceImplem(CustomerRepository customerRepository) {
		System.out.println("Hey Hey. Constructor injection!!! ");
		this.custRepos = customerRepository;
	}
	
	@Autowired
	public void setCustRepos(CustomerRepository custRepos) {
		System.out.println("Setting using autowired");
		this.custRepos = custRepos;
	}


	public List<Customer> findAll() {
		return custRepos.findAll();
	}

}

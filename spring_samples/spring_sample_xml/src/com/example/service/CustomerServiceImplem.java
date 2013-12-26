package com.example.service;

import java.util.List;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

public class CustomerServiceImplem implements CustomerService {
	private CustomerRepository custRepos;
	
	public CustomerServiceImplem() {}
	
	public CustomerServiceImplem(CustomerRepository cr) {
		this.custRepos = cr;
	}
	
	public void setCustRepos(CustomerRepository custRepos) {
		this.custRepos = custRepos;
	}

	public List<Customer> findAll() {
		return custRepos.findAll();
	}

}

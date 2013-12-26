package com.example.service;

import java.util.List;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.HibernateCustomerRepositoryImplem;

public class CustomerServiceImplem implements CustomerService {
	private CustomerRepository custRepos = new HibernateCustomerRepositoryImplem();
	
	public List<Customer> findAll() {
		return custRepos.findAll();
	}

}

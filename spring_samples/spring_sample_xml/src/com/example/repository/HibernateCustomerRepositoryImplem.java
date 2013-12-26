package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class HibernateCustomerRepositoryImplem implements CustomerRepository {

	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer cus = new Customer();
		cus.setFirstname("Hes");
		cus.setLastname("Ges");
		customers.add(cus);
		return customers;
	}
}

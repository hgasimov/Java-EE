package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImplem implements CustomerRepository {
	
	@Value("${propName}")
	private String propValue;

	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer cus = new Customer();
		//cus.setFirstname("Hes");
		cus.setFirstname(propValue);
		cus.setLastname("Ges");
		customers.add(cus);
		return customers;
	}
}

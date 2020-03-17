package com.adiops.loyality.api.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adiops.loyality.api.customer.entity.Customer;

@Component
public class CustomerRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(CustomerRepositoryCommandLineRunner.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Customer user = new Customer("Jill", "9898989898");
		customerRepository.save(user);
		log.info("New User is created : " + user);
		
		
		List<Customer> users = customerRepository.findAll();
		log.info("All Users : " + users);	
		
	}

}

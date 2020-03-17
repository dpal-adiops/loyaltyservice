package com.adiops.loyality.api.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiops.loyality.api.customer.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String>{

}

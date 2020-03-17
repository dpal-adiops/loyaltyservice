package com.adiops.loyality.api.customer.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adiops.loyality.api.customer.entity.Customer;
import com.adiops.loyality.api.customer.exception.CustomerNotFoundException;
import com.adiops.loyality.api.customer.service.CustomerRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest") 
public class CustomerResource {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customers/{id}")
	@ApiOperation(value = "Finds customers by id",
    notes = "Also returns a link to retrieve all customers with rel - all-customers")
	public Customer retrieveCustomer(@PathVariable String id) throws CustomerNotFoundException {

		Customer customer = customerRepository.getOne(id);
		if (customer == null)
			throw new CustomerNotFoundException("id-" + id);

		return customer;
	}

	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer user) {
		Customer savedUser = customerRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/customers/{id}")
	public void deleteUser(@PathVariable String id) {
		customerRepository.deleteById(id);
	}
}

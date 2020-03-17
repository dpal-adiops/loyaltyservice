package com.adiops.loyality.api.store.resource;

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

import com.adiops.loyality.api.store.entity.Store;
import com.adiops.loyality.api.store.exception.StoreNotFoundException;
import com.adiops.loyality.api.store.service.StoreRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest") 
public class StoreResource {

	@Autowired
	private StoreRepository storeRepository;

	@GetMapping("/stores")
	public List<Store> getAllStores() {
		return storeRepository.findAll();
	}

	@GetMapping("/stores/{id}")
	@ApiOperation(value = "Finds stores by id",
    notes = "Also returns a link to retrieve all stores with rel - all-stores")
	public Store retrieveStore(@PathVariable String id) throws StoreNotFoundException {

		Store store = storeRepository.getOne(id);
		if (store == null)
			throw new StoreNotFoundException("id-" + id);

		return store;
	}

	@PostMapping("/stores")
	public ResponseEntity<Object> createStore(@Valid @RequestBody Store user) {
		Store savedUser = storeRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/stores/{id}")
	public void deleteUser(@PathVariable String id) {
		storeRepository.deleteById(id);
	}
}

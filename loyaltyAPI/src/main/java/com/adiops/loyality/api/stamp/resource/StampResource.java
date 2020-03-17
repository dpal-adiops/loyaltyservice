package com.adiops.loyality.api.stamp.resource;

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

import com.adiops.loyality.api.stamp.entity.Stamp;
import com.adiops.loyality.api.stamp.exception.StampNotFoundException;
import com.adiops.loyality.api.stamp.service.StampRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest") 
public class StampResource {

	@Autowired
	private StampRepository stampRepository;

	@GetMapping("/stamps")
	public List<Stamp> getAllStamps() {
		return stampRepository.findAll();
	}

	@GetMapping("/stamps/{id}")
	@ApiOperation(value = "Finds stamps by id",
    notes = "Also returns a link to retrieve all stamps with rel - all-stamps")
	public Stamp retrieveStamp(@PathVariable String id) throws StampNotFoundException {

		Stamp stamp = stampRepository.getOne(id);
		if (stamp == null)
			throw new StampNotFoundException("id-" + id);

		return stamp;
	}

	@PostMapping("/stamps")
	public ResponseEntity<Object> createStamp(@Valid @RequestBody Stamp user) {
		Stamp savedUser = stampRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/stamps/{id}")
	public void deleteUser(@PathVariable String id) {
		stampRepository.deleteById(id);
	}
}

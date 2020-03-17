package com.adiops.loyality.api.stamp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adiops.loyality.api.stamp.entity.Stamp;

@Component
public class StampRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(StampRepositoryCommandLineRunner.class);

	@Autowired
	private StampRepository stampRepository;

	@Override
	public void run(String... args) throws Exception {
		
		List<Stamp> users = stampRepository.findAll();
		log.info("All Users : " + users);

	}

}

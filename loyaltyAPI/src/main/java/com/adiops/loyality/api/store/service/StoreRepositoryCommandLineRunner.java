package com.adiops.loyality.api.store.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adiops.loyality.api.store.entity.Store;

@Component
public class StoreRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(StoreRepositoryCommandLineRunner.class);

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public void run(String... args) throws Exception {
		Store user = new Store("chayos", "9898989898");
		storeRepository.save(user);
		log.info("New User is created : " + user);

		List<Store> users = storeRepository.findAll();
		log.info("All Users : " + users);

	}

}

package com.adiops.loyality.api.store.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiops.loyality.api.store.entity.Store;


public interface StoreRepository extends JpaRepository<Store, String>{

}

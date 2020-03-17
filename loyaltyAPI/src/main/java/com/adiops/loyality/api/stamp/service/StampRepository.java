package com.adiops.loyality.api.stamp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adiops.loyality.api.stamp.entity.Stamp;


public interface StampRepository extends JpaRepository<Stamp, String>{

}

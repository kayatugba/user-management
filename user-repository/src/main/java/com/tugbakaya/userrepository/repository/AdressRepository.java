package com.tugbakaya.userrepository.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tugbakaya.userrepository.entity.AdressEntity;

public interface AdressRepository extends CrudRepository<AdressEntity, Integer>{
	
	List<AdressEntity> findByStreetIgnoreCaseContaining(String street);

}

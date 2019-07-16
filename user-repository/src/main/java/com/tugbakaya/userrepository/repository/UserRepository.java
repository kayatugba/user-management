package com.tugbakaya.userrepository.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tugbakaya.userrepository.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer>{
	
	List<UserEntity> findByNameIgnoreCaseContaining(String name);
	
	List<UserEntity> findBySurnameIgnoreCaseContaining(String surname);
	
	List<UserEntity> findDistinctByAdressesStreetIgnoreCaseContaining(String street);
	
	@Query("select u from UserEntity u where :minute < CURRENT_TIMESTAMP - u.creationDate and u.oldUser = false")
	List<UserEntity> findTimeoutUsers(@Param("minute") Integer minute);
	
	@Modifying
	@Transactional
	void deleteByCreationDateBefore(Date beforeDate);
	
	//public void deleteByCreatedAtBefore(Date expiryDate);
	List<UserEntity>  findByCreationDateBeforeAndOldUser(Date beforeDate, boolean oldUser);
	
	List<UserEntity>  findByCreationDateBefore(Date beforeDate);
	
	
	@Transactional
	@Modifying
	@Query("update UserEntity user set user.oldUser = true where user.id = :userId")
	void setOldUserforUser(Integer userId);
	
}

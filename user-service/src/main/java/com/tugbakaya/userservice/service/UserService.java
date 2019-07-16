package com.tugbakaya.userservice.service;

import java.util.Date;
import java.util.List;

import com.tugbakaya.userrepository.entity.UserEntity;

public interface UserService {

	Iterable<UserEntity> findAllUsers();

	UserEntity saveUser(UserEntity user);

	void deleteUser(Integer id);

	UserEntity updateUser(UserEntity user);

	UserEntity findById(int id);

	List<UserEntity> findByUserName(String name);

	List<UserEntity> findByUserSurname(String surname);

	List<UserEntity> findByAdressStreet(String street);

	List<UserEntity> findTimeoutUsers(Date beforeDate);

	void deleteTimeoutUsers(Date beforeDate);

	void udpateOldUsers(Date beforeDate);

}

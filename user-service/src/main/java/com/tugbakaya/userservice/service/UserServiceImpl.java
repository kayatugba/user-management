package com.tugbakaya.userservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugbakaya.userrepository.entity.UserEntity;
import com.tugbakaya.userrepository.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Iterable<UserEntity> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);

	}

	@Override
	public UserEntity findById(int id) {
		return (UserEntity) userRepository.findById(id).get();
	}

	@Override
	public List<UserEntity> findByUserName(String name) {
		return userRepository.findByNameIgnoreCaseContaining(name);
	}

	@Override
	public List<UserEntity> findByUserSurname(String surname) {
		return userRepository.findBySurnameIgnoreCaseContaining(surname);
	}

	@Override
	public List<UserEntity> findTimeoutUsers(Date beforeDate) {
		return userRepository.findByCreationDateBeforeAndOldUser(beforeDate,false);
		//return userRepository.findByCreationDateBefore(beforeDate);
	}

	@Override
	public void deleteUser(Integer id) {

		userRepository.deleteById(id);

	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public List<UserEntity> findByAdressStreet(String street) {
		return userRepository.findDistinctByAdressesStreetIgnoreCaseContaining(street);
	}

	@Override
	public void deleteTimeoutUsers(Date beforeDate) {
		userRepository.deleteByCreationDateBefore(beforeDate);

	}

	@Override
	public void udpateOldUsers(Date beforeDate) {
		List<UserEntity> timeoutUsers = findTimeoutUsers(beforeDate);
		for(UserEntity user : timeoutUsers)
		{
			userRepository.setOldUserforUser(user.getId());
		}

	}

}

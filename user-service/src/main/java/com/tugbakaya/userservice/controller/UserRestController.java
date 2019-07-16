package com.tugbakaya.userservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tugbakaya.userrepository.entity.UserEntity;
import com.tugbakaya.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> listAllUsers() {
		Iterator it = userService.findAllUsers().iterator();
		List<UserEntity> users = new ArrayList<UserEntity>();
		while (it.hasNext()) {
			users.add((UserEntity) it.next());
		}
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserEntity>>(HttpStatus.NO_CONTENT);
		}
		// System.out.println(users.get(0).getCreationDate() - new Date());
		return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);

	}

	// bunu postla yapmamız gerekmiyor mu
	// reponse entity response body difference
	// param metin olarak gönderme farkı
	// direk nesneye map edebiliyoduk
//	@GetMapping(path = "/add")
//	public ResponseEntity<?> addNewUser(@RequestParam String name, @RequestParam String surname,
//			@RequestParam @DateTimeFormat(pattern = "ddMMyyyy") Date dateReceived) {
//
//		User user = new User();
//		user.setName(name);
//		user.setSurname(surname);
//		user.setBirthDate(dateReceived);
//		userService.saveUser(user);
//		return new ResponseEntity<>(HttpStatus.OK);
//
//	}

	@PostMapping(path = "/add")
	public ResponseEntity<?> addUser(@RequestBody UserEntity user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);

	}

	@DeleteMapping(path = "/delete")
	public ResponseEntity<?> deleteUser(@RequestParam Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping(path = "/update")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);

	}

	@GetMapping(path = "/findUserByName")
	public ResponseEntity<List<UserEntity>> findUserByName(@RequestParam String name) {
		return new ResponseEntity<>(userService.findByUserName(name), HttpStatus.OK);

	}

	@GetMapping(path = "/findUserBySurname")
	public ResponseEntity<List<UserEntity>> findUserBySurname(@RequestParam String surname) {
		return new ResponseEntity<>(userService.findByUserSurname(surname), HttpStatus.OK);

	}

	@GetMapping(path = "/findUserByAdressStreet")
	public ResponseEntity<List<UserEntity>> findUserByAdressStreet(@RequestParam String street) {
		return new ResponseEntity<>(userService.findByAdressStreet(street), HttpStatus.OK);

	}

	@GetMapping(path = "/findTimeoutUsers")
	public ResponseEntity<List<UserEntity>> findTimeoutUsers(@RequestParam Integer minute) {
		Date beforeDate = new Date(System.currentTimeMillis() - minute * 60 * 1000);
		System.out.println("beforeDAteeeeeeeeeeeeeeeeeeeeeeee " + beforeDate.toString());
		return new ResponseEntity<>(userService.findTimeoutUsers(beforeDate), HttpStatus.OK);

	}

	@GetMapping(path = "/deleteTimeoutUsers")
	public ResponseEntity<List<UserEntity>> deleteTimeoutUsers(@RequestParam Integer minute) {
		Date beforeDate = new Date(System.currentTimeMillis() - minute * 60 * 1000);
		System.out.println("beforeDAteeeeeeeeeeeeeeeeeeeeeeee deletee" + beforeDate.toString());
		userService.deleteTimeoutUsers(beforeDate);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@GetMapping(path = "/updateOldUsers")
	public ResponseEntity<List<UserEntity>> updateOldUsers(@RequestParam Integer minute) {
		Date beforeDate = new Date(System.currentTimeMillis() - minute * 60 * 1000);
		System.out.println("beforeDAteeeeeeeeeeeeeeeeeeeeeeee deletee" + beforeDate.toString());
		userService.udpateOldUsers(beforeDate);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}

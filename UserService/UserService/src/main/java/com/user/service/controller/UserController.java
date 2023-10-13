package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUsers")
	public ResponseEntity<User>createUser(@RequestBody User user){
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User>getSingleUser(@PathVariable String userId){
		User user1=userService.getUser(userId);
		return ResponseEntity.ok(user1);
	}
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteByUserId(@PathVariable String userId) {
		String msg=userService.deleteUser(userId);
		return msg;
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User>updateUser(@RequestBody User user, @PathVariable String userId){
		User user1=userService.updateUser(user,userId);
		return ResponseEntity.status(HttpStatus.OK).body(user1);
	}
	
	
}

package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;

@RestController
@RequestMapping(path="api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
		
	}
	
	@GetMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getAnUser(@PathVariable (name="id")Long id){
		return new ResponseEntity<User>(userService.findUserById(id),HttpStatus.OK);
		
	}
	
	@DeleteMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUser(@PathVariable (name="id")Long id){
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
		
	}
	
	@PutMapping(path="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable (name="id")Long id,@RequestBody User user){
		userService.updateUser(id, user);
		return new ResponseEntity<User>(userService.updateUser(id, user),HttpStatus.OK);
		
	}
	
	
	
	
	
	

}

package com.group3.springrest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.springrest.exceptions.ResourceNotFoundException;
import com.group3.springrest.models.Users;
import com.group3.springrest.repository.UsersRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/u1")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	//http://localhost:9095/api/u1/users
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		System.out.println("hello");
		return usersRepository.findAll();
	}
	
	@PostMapping("/createusers")
	public Users createUser(@Valid @RequestBody Users user) {
		return usersRepository.save(user);
	}
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<Users> getUserById(@PathVariable(value = "user_id") Integer userId)
	throws ResourceNotFoundException {
		Users user = usersRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException ("User not found for this id :: " + userId));
	return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/updateusers/{user_id}")
	public ResponseEntity<Users> updateUser(@PathVariable(value = "user_id") Integer userId,
											@Valid @RequestBody Users userDetails) throws ResourceNotFoundException {
		Users user = usersRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException ("User not found for this id :: " + userId));
		
		user.setfName(userDetails.getfName());
		user.setlName(userDetails.getlName());
		user.setEmail(userDetails.getEmail());
		user.setUsername(userDetails.getUsername());
		final Users updateUser = usersRepository.save(user);
		return ResponseEntity.ok(updateUser);
		
	}

}

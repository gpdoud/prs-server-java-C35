package com.maxtrain.capstone.user;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("{username}/{password}")
	public ResponseEntity<User> login(@PathVariable String username, @PathVariable String password) {
		var user = userRepo.findByUsernameAndPassword(username, password);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		var users = userRepo.findAll();
		return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		var user = userRepo.findById(id);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> postUser(@RequestBody User user) {
		if(user == null || user.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var usr = userRepo.save(user);
		return new ResponseEntity<User>(usr, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity putCustomer(@PathVariable int id, @RequestBody User user) {
		if(user == null || user.getId() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		var usr = userRepo.findById(user.getId());
		if(usr.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userRepo.save(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		var user = userRepo.findById(id);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userRepo.delete(user.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

package com.poc1.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc1.app.model.User;
import com.poc1.app.service.UserServiceImp;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	@GetMapping()
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok(userService.getOnlyActiveUsers());
	}

	
	@PostMapping("/register")
	public String addUser(@RequestBody User user) {
		userService.saveUser(user);
		return "Saved Successfully";
	}
	
	@PutMapping("/edit/{id}")
	public User updateUser(@RequestBody User user,@PathVariable Long id) {
		User u = userService.updateUserId(user,id);
		return u;
	}
	
	//HardDelete
	@DeleteMapping("/delete/{id}")
	public String hardDeleteUser(@PathVariable Long id) {
		userService.hardDeleteUser(id);
		return "Deleted Successfully";
	}
	
	//soft-Delete
	@DeleteMapping("/delete/soft/{id}")
	public String softDeleteUser(@PathVariable Long id) {
		userService.softDeleteUser("no", id);;
		return "Soft Deleted Successfully";
	}
	
	@GetMapping("/sort/name")
	public List<User> sortUsersByName(){
		return userService.sortUsersByName();
	}
	
	@GetMapping("/sort/surname")
	public List<User> sortUsersBySurname(){
		return userService.sortUsersBySurname();
	}
	
	@GetMapping("/sort/dob")
	public List<User> sortUsersByDob(){
		return userService.sortUsersByDob();
	}
	
	@GetMapping("/sort/joiningdate")
	public List<User> sortUsersByJoiningDate(){
		return userService.sortUsersByJoiningDate();
	}
	
	@GetMapping("/sort/pincode")
	public List<User> sortUsersByPincode(){
		return userService.sortUsersByPincode();
	}
	
	
}

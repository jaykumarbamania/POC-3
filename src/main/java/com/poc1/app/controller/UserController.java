package com.poc1.app.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc1.app.model.User;
import com.poc1.app.service.UserServiceImp;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	public UserController(UserServiceImp userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getusers")
	public List<User> getAllUsers(){
//		return ResponseEntity.ok(userService.getOnlyActiveUsers());
		return userService.getAllUsers();
	}


	@GetMapping("/users")
	public List<User> getOnlyActiveUsers(){
//		return ResponseEntity.ok(userService.getOnlyActiveUsers());
		return userService.getOnlyActiveUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id){
//		return ResponseEntity.ok(userService.getOnlyActiveUsers());
		return userService.getUserById(id);
	}

	
	@PostMapping("/register")
	public String addUser(@RequestBody User user) {
		userService.saveUser(user);
		return (user.getName()+" "+user.getSurname()+" added successfully");
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
		return "Id "+id+" Deleted Successfully";
	}
	
	//soft-Delete
	@DeleteMapping("/delete/soft/{id}")
	public String softDeleteUser(@PathVariable Long id) {
		userService.softDeleteUser("no", id);
		return "Id "+id+" Soft Deleted Successfully";
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
	
	@GetMapping("search/name/{name}")
	public List<User> searchUserByName(@PathVariable String name){
		return userService.searchByName(name);
	}
	
	@GetMapping("search/surname/{surname}")
	public List<User> searchUserBySurname(@PathVariable String surname){
		return userService.searchBySurname(surname);
	}
	
	@GetMapping("search/dob/{dob}")
	public List<User> searchUserByDob(@PathVariable String dob){
		return userService.searchByDob(dob);
	}
	
	@GetMapping("search/pincode/{pincode}")
	public List<User> searchUserByPincode(@PathVariable String pincode){
		return userService.searchByPincode(pincode);
	}
	
	@GetMapping("search/joiningdate/{joiningdate}")
	public List<User> searchUserByJoiningDate(@PathVariable String joiningdate){
		return userService.searchByJoiningDate(joiningdate);
	}
	
}

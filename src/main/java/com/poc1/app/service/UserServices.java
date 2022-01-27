package com.poc1.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.poc1.app.model.User;


public interface UserServices {
	
	//get users
	List<User> getAllUsers();
	
	List<User> getOnlyActiveUsers();
	
	//Optional<User> findByUserNameAndPass(String username, String password);
	
	User getUserById(Long id);
	
	//save
	User saveUser(User u);
	
	//deletion
	Long hardDeleteUser(Long id);
	
	Long softDeleteUser(String status,Long id);
	
	//Update
	User updateUserId(User user,Long id);
	
	
	//sorting
	List<User> sortUsersByName();
	
	List<User> sortUsersBySurname();
	
	List<User> sortUsersByDob();
	
	List<User> sortUsersByJoiningDate();

	List<User> sortUsersByPincode();
	
	//searching
	List<User> searchByName(String name);
	
	List<User> searchBySurname(String surname);
	
	List<User> searchByDob(String Dob );
	
	List<User> searchByPincode(String pincode );
	
	List<User> searchByJoiningDate(String joiningdate );
	

}

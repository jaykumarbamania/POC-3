package com.poc1.app.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc1.app.model.User;
import com.poc1.app.repository.UserReposiotry;

@Service
public class UserServiceImp implements UserServices{
	
	
	private UserReposiotry userRepo;
	
	@Autowired
	public void setUserRepo(UserReposiotry userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}
	
	@Override
	public List<User> getOnlyActiveUsers() {
		return ((List<User>) userRepo.findAll()).stream().filter(u -> u.getActive().equals("yes")).collect(Collectors.toList());
	}

	@Override
	public User saveUser(User u) {
		return userRepo.save(u);
	}

	@Override
	public Long hardDeleteUser(Long id) {
		userRepo.deleteById(id);
		return id;
	}
	
	@Override
	public Long softDeleteUser(String status,Long id) {
		userRepo.deleteStatus(status, id);
		return id;
	}

	@Override
	public User updateUserId(User user,Long id) {
		User existingUser =userRepo.findById(id).get();
		existingUser.setId(existingUser.getId());
		existingUser.setName(user.getName());
		existingUser.setSurname(user.getSurname());
		existingUser.setDob(user.getDob());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setPincode(user.getPincode());
		existingUser.setJoiningdate(user.getJoiningdate());
		existingUser.setActive(user.getActive());
		return userRepo.save(existingUser);
	}
	
	@Override
	public List<User> sortUsersByName(){
		Comparator<User> byName = Comparator.comparing(User::getName);
		return getOnlyActiveUsers().stream().sorted(byName).collect(Collectors.toList());
	}
	
	@Override
	public List<User> sortUsersBySurname(){
		Comparator<User> bySurname = Comparator.comparing(User::getSurname);
		return getOnlyActiveUsers().stream().sorted(bySurname).collect(Collectors.toList());
	}

	@Override
	public List<User> sortUsersByDob() {
		Comparator<User> byDob = Comparator.comparing(User::getDob);
		return getOnlyActiveUsers().stream().sorted(byDob).collect(Collectors.toList());
	}

	@Override
	public List<User> sortUsersByJoiningDate() {
		Comparator<User> byJoiningDate = Comparator.comparing(User::getJoiningdate);
		return getOnlyActiveUsers().stream().sorted(byJoiningDate).collect(Collectors.toList());
	}

	@Override
	public List<User> sortUsersByPincode() {
		Comparator<User> byPincode = Comparator.comparing(User::getPincode);
		return getOnlyActiveUsers().stream().sorted(byPincode).collect(Collectors.toList());
	}

	public UserServiceImp(UserReposiotry userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public List<User> searchByName(String name) {
		return this.userRepo.findByName(name);
	}

	@Override
	public List<User> searchBySurname(String surname) {
		return this.userRepo.findBySurname(surname);
	}

	@Override
	public List<User> searchByDob(String dob) {
		return this.userRepo.findByDob(dob);
	}

	@Override
	public List<User> searchByPincode(String pincode) {
		return this.userRepo.findByPincode(pincode);
	}

	@Override
	public List<User> searchByJoiningDate(String joiningdate) {
		return this.userRepo.findByJoiningdate(joiningdate);
	}


	
}

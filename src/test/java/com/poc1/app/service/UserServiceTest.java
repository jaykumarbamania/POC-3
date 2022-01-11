package com.poc1.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.poc1.app.model.User;
import com.poc1.app.repository.UserReposiotry;



@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	
	@Autowired
    MockMvc mockMvc;
	
	@Mock
	private UserReposiotry userRepo;
	
	@Autowired
    @InjectMocks
	private UserServiceImp userService;
	
	User mockUser1  = new User((long) 23,"AAA","xxx","aaa23@gmail.com","9843322313",new Date(1980-8-14),"380013","yes",new Date(2000-10-15));
	User mockUser2  = new User((long) 24,"DDD","eee","ddd24@gmail.com","9843322314",new Date(1988-8-14),"380014","no",new Date(2006-10-15));
	User mockUser3  = new User((long) 25,"CCC","fff","ccc25@gmail.com","9843322315",new Date(1990-8-14),"380015","yes",new Date(2010-10-15));
	
	List<User> userList = new ArrayList<>
	(Arrays.asList(mockUser1, mockUser2, mockUser3));

		
	 @Test
	 void testGetAllUsers() throws Exception{
		     
		     when(userRepo.findAll()).thenReturn(userList);
		     List<User> userList1 =userService.getAllUsers();
		     assertEquals(userList1,userList);
	 }
	
	 @Test
	 void givenUserToAddShouldReturnAddedUser() throws Exception{
	      //stubbing
	      when(userRepo.save(mockUser1)).thenReturn(mockUser1);
	      userService.saveUser(mockUser1);
	      verify(userRepo,times(1)).save(mockUser1);
	 }
	 
	 @Test
	 public void GivenGetAllUsersShouldReturnListOfAllUsers(){
	      userRepo.save(mockUser1);
	     //stubbing mock to return specific data
	     when(userRepo.findAll()).thenReturn(userList);
	     List<User> userList1 =userService.getAllUsers();
	     assertEquals(userList1,userList);
	     verify(userRepo,times(1)).save(mockUser1);
	     verify(userRepo,times(1)).findAll();
	 }
	 
	 @Test
	 public void givenIdThenShouldReturnUserOfThatId() {
	    Mockito.when(userRepo.findById((long)23)).thenReturn(Optional.ofNullable(mockUser1));
	    assertThat(userService.getUserById(mockUser1.getId())).isEqualTo(mockUser1);
	 }
	 
	 @Test
	 public void testGetOnlyActiveUsers() throws Exception {

		 List<User> userList2 =userList.stream().filter(u -> u.getActive().equals("yes")).collect(Collectors.toList());
	    when(userService.getOnlyActiveUsers()).thenReturn(userList2);
	    
	    assertEquals(userList2,userService.getOnlyActiveUsers());
	 }
	 
	 @Test
	 public void testHardDeleteUser() throws Exception {
		 
	    when(userService.hardDeleteUser((long) 24)).thenReturn(mockUser2.getId());
	    
	    assertEquals("",userService.hardDeleteUser((long) 24));
	 }
	 
	 @Test
	 public void testSoftDeleteUser() throws Exception {
		 User mockUser1  = new User((long) 23,"AAA","xxx","aaa23@gmail.com","9843322313",new Date(1980-8-14),"380013","yes",new Date(2000-10-15));
		 userRepo.save(mockUser1);
	    when(userRepo.deleteStatus("no",(long) 23)).thenReturn(23);
	    userService.softDeleteUser("no",(long) 23);
	    assertEquals("yes",mockUser1.getActive());
	 }
	 
	 @Test
	 public void testUpdateUserId() throws Exception {

		 	User user  = new User((long) 23,"AAA","xxx","aaa23@gmail.com","9843322313",new Date(1980-8-14),"380013","yes",new Date(2000-10-15));
		 	userRepo.save(user);
		 	assertThat(user.getName()).isEqualTo("AAA");
		 	User updatedUser =user;
		 	updatedUser.setId(updatedUser.getId());
		 	updatedUser.setName("Updated UserName");
			updatedUser.setSurname("Surname");
			updatedUser.setDob(user.getDob());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPhone(user.getPhone());
			updatedUser.setPincode(user.getPincode());
			updatedUser.setJoiningdate(user.getJoiningdate());
			updatedUser.setActive(user.getActive());
			userService.saveUser(updatedUser);
			Mockito.when(userService.getUserById(user.getId())).thenReturn(user);

			Mockito.when(userService.updateUserId(updatedUser,updatedUser.getId())).thenReturn(updatedUser);

			assertThat(userService.updateUserId(updatedUser, (long) 23)).isEqualTo(updatedUser);

	 }
	 
	 @Test
	 public void testSortUsersByName() throws Exception {
		 Comparator<User> byName = Comparator.comparing(User::getName);
		 List<User> sortUserList =  userList.stream().sorted(byName).collect(Collectors.toList());
//		 List<User> userList2 =userList.stream().filter(u -> u.getActive().equals("yes")).collect(Collectors.toList());
	    when(userService.sortUsersByName()).thenReturn(userList);
	    
	    assertEquals(sortUserList,userService.sortUsersByName());
	 }
	 
	 @Test
	 public void testSortUsersBySurName() throws Exception {
		 Comparator<User> bySurName = Comparator.comparing(User::getSurname);
		 List<User> sortUserList =  userList.stream().sorted(bySurName).collect(Collectors.toList());
//		 List<User> userList2 =userList.stream().filter(u -> u.getActive().equals("yes")).collect(Collectors.toList());
	    when(userService.sortUsersBySurname()).thenReturn(userList);
	    
	    assertEquals(sortUserList,userService.sortUsersBySurname());
	 }
	 
	 @Test
	 public void testSortUsersByDob() throws Exception {
		 Comparator<User> byDob = Comparator.comparing(User::getDob);
		 List<User> sortUserList =  userList.stream().sorted(byDob).collect(Collectors.toList());
	    when(userService.sortUsersByDob()).thenReturn(userList);
	    
	    assertEquals(sortUserList,userService.sortUsersByDob());
	 }
	 
	 @Test
	 public void testSortUsersByJoiningDate() throws Exception {
		 Comparator<User> byJD = Comparator.comparing(User::getJoiningdate);
		 List<User> sortUserList =  userList.stream().sorted(byJD).collect(Collectors.toList());
	    when(userService.sortUsersByJoiningDate()).thenReturn(userList);
	    
	    assertEquals(sortUserList,userService.sortUsersByJoiningDate());
	 }
	 
	 @Test
	 public void testSortUsersByPincode() throws Exception {
		 Comparator<User> byPincode = Comparator.comparing(User::getPincode);
		 List<User> sortUserList =  userList.stream().sorted(byPincode).collect(Collectors.toList());
	    when(userService.sortUsersByPincode()).thenReturn(userList);
	    
	    assertEquals(sortUserList,userService.sortUsersByPincode());
	 }
}

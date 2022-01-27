package com.poc1.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poc1.app.model.User;

@Repository
public interface UserReposiotry extends CrudRepository<User,Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.active = :active WHERE u.id = :id")
	int deleteStatus(@Param("active") String status,@Param("id") Long id);
	
	@Query(value="select * from User u where u.name like %:name% and u.active='yes'", nativeQuery=true)
	List<User> findByName(@Param("name") String name);
	
	@Query(value="select * from User u where u.surname like %:surname% and u.active='yes'", nativeQuery=true)
	List<User> findBySurname(@Param("surname") String surname);
	
	@Query(value="select * from User u where u.dob like %:dob% and u.active='yes'", nativeQuery=true)
	List<User> findByDob(@Param("dob") String dob);
	
	@Query(value="select * from User u where u.pincode like %:pincode% and u.active='yes'", nativeQuery=true)
	List<User> findByPincode(@Param("pincode") String pincode);
	
	@Query(value="select * from User u where u.joiningdate like %:joiningdate% and u.active='yes'", nativeQuery=true)
	List<User> findByJoiningdate(@Param("joiningdate") String joiningdate);
}

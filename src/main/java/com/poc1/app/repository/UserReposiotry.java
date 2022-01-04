package com.poc1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.poc1.app.model.User;

public interface UserReposiotry extends JpaRepository<User,Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.active = :active WHERE u.id = :id")
	void deleteStatus(@Param("active") String status,@Param("id") Long id);

}

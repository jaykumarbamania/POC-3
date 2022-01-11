package com.poc1.app.model;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	private String name;
	
	@NotNull
	@Size(max = 65)
	private String surname;
	
	@NotNull
	@Size(max = 100)
	private String email;
	
	@Size(max= 15)
	@NotNull
	@Column(name="phone",unique = true)
	private String phone;
	
	private Date dob;
	
	@NotNull
	@Size(max = 10)
	private String pincode;
	
	
	private String active;
//	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningdate;
	
}

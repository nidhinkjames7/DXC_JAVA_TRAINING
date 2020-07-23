package com.dxc.bankapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankinfo")
public class Customer 
{

	@Column(name = "mid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "fname", nullable = true, length = 255)
	private String fname;

	@Column(name = "lname", nullable = true, length = 255)
	private String lname;

	@Column(name = "email", nullable = true, length = 255)
	private String email;

	@Column(name = "phone", nullable = true, length = 255)
	private String phone;
	
	@Column (name="age", nullable = true, length=255)
	private String age;
	
}

package com.vms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "show_room_table")
public class ShowRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String address;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ShowRoom(Integer id, String address, String email, Brand brand) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
		this.brand = brand;
	}

	public ShowRoom(String address, String email, Brand brand) {
		super();
		this.address = address;
		this.email = email;
		this.brand = brand;
	}

	public ShowRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

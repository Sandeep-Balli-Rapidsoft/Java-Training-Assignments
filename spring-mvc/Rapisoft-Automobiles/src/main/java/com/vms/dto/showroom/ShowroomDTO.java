package com.vms.dto.showroom;

import java.util.Date;

import com.vms.entity.Brand;

public class ShowroomDTO {

	private Integer id;

	private String address;

	private String email;

	private Brand brand;

	private Date createdAt;

	private Date updatedAt;

	private Boolean isActive = true;

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public ShowroomDTO(Integer id, String address, String email, Brand brand, Date createdAt, Date updatedAt,
			Boolean isActive) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
		this.brand = brand;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	public ShowroomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}

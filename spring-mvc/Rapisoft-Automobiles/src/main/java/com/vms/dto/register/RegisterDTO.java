package com.vms.dto.register;

import java.util.Date;

import com.vms.entity.User;
import com.vms.entity.Vehicle;

public class RegisterDTO {
	
	private Integer id;

	private Date createdAt;

	private Date updatedAt;

	private Vehicle vehicle;

	private User user;

	private String vehicleNumber;

	private Boolean isActive = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public RegisterDTO(Integer id, Date createdAt, Date updatedAt, Vehicle vehicle, User user, String vehicleNumber,
			Boolean isActive) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.vehicle = vehicle;
		this.user = user;
		this.vehicleNumber = vehicleNumber;
		this.isActive = isActive;
	}

	public RegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

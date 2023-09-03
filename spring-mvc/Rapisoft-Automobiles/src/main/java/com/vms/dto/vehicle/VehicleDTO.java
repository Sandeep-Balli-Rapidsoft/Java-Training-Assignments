package com.vms.dto.vehicle;

import java.util.Date;

import com.util.MyEnum;
import com.vms.entity.ShowRoom;

public class VehicleDTO {
	private String name;
	
	private Integer id;

	private MyEnum vehicleType;

	private String engineCode;

	private String chassisNumber;

	private Double price;

	private Boolean isAvailable = true;

	private Date createdAt;

	private Date updatedAt;

	private Boolean isActive = true;

	private ShowRoom showroom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyEnum getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(MyEnum vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
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

	public ShowRoom getShowroom() {
		return showroom;
	}

	public void setShowroom(ShowRoom showroom) {
		this.showroom = showroom;
	}

	public VehicleDTO(Integer id, String name, MyEnum vehicleType, String engineCode, String chassisNumber,
			Double price, Boolean isAvailable, Date createdAt, Date updatedAt, Boolean isActive, ShowRoom showroom) {
		super();
		this.id = id;
		this.name = name;
		this.vehicleType = vehicleType;
		this.engineCode = engineCode;
		this.chassisNumber = chassisNumber;
		this.price = price;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.showroom = showroom;
	}

	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}

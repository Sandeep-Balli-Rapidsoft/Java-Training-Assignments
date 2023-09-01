package com.vms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.util.MyEnum;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vehicle_type", nullable = false)
    private MyEnum vehicleType;

    @Column(name = "engine_code", nullable = false)
    private String engineCode;

    @Column(name = "chassis_number", nullable = false)
    private String chassisNumber;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
    
    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "showroom_id", nullable = false)
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

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
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

	public Vehicle(String name, MyEnum vehicleType, String engineCode, String chassisNumber, String vehicleNumber,
			Double price, Boolean isAvailable, Date createdAt, Date updatedAt, Boolean isActive, ShowRoom showroom) {
		super();
		this.name = name;
		this.vehicleType = vehicleType;
		this.engineCode = engineCode;
		this.chassisNumber = chassisNumber;
		this.vehicleNumber = vehicleNumber;
		this.price = price;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.showroom = showroom;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

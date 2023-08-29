package com.vms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

enum MyEnum {
	CAR, BIKE, SCOOTY
}

@Entity
@Table(name = "vehicle_table")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private MyEnum vehicle_type;

	private String engine_code;

	private String chassis_number;

	private String vehicle_number;

	private Date date;

	private Double price;

	private Boolean isAvailable = true;

	@ManyToOne
	@JoinColumn(name = "show_room_id")
	private ShowRoom showRoom;

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

	public MyEnum getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(MyEnum vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getEngine_code() {
		return engine_code;
	}

	public void setEngine_code(String engine_code) {
		this.engine_code = engine_code;
	}

	public String getChassis_number() {
		return chassis_number;
	}

	public void setChassis_number(String chassis_number) {
		this.chassis_number = chassis_number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ShowRoom getShowRoom() {
		return showRoom;
	}

	public void setShowRoom(ShowRoom showRoom) {
		this.showRoom = showRoom;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String name, MyEnum vehicle_type, String engine_code, String chassis_number, String vehicle_number,
			Date date, Double price, Boolean isAvailable, ShowRoom showRoom) {
		super();
		this.name = name;
		this.vehicle_type = vehicle_type;
		this.engine_code = engine_code;
		this.chassis_number = chassis_number;
		this.vehicle_number = vehicle_number;
		this.date = date;
		this.price = price;
		this.isAvailable = isAvailable;
		this.showRoom = showRoom;
	}

}

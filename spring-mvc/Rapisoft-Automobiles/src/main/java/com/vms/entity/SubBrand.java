package com.vms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_brand_table")
public class SubBrand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "vehicle_type")
	private String vehicle_type;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public SubBrand(String vehicle_type, Brand brand) {
		super();
		this.vehicle_type = vehicle_type;
		this.brand = brand;
	}

	public SubBrand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

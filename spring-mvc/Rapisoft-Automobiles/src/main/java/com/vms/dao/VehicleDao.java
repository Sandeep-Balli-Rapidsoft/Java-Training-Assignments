package com.vms.dao;

import java.util.List;

import com.vms.entity.Vehicle;

public interface VehicleDao {
	
	
	public void save(Vehicle vehicle);
	
	public void update(Vehicle vehicle);
	
	public Vehicle getById(Vehicle vehicle);
	
	public List<Vehicle> getAll();
	
	public String getByName(Vehicle vehicle);
}

package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.VehicleDao;
import com.vms.entity.Vehicle;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	public void saveVehicle(Vehicle vehicle) {
		this.vehicleDao.saveVehicle(vehicle);
	}
	
	public List<Vehicle> vehicleList() {
		return this.vehicleDao.vehicleList();
	}
}

package com.vms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.VehicleDao;
import com.vms.entity.ShowRoom;
import com.vms.entity.Vehicle;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	public String getVehicleByBrand(Vehicle vehicle) {
		String str = this.vehicleDao.getByName(vehicle);
		return str;
	}
	
	public void saveVehicle(Vehicle vehicle) {
		
		List<Vehicle> list = this.vehicleDao.getAll();
		List<Vehicle> specificBrandList = new ArrayList<>();
		
		
		//  [i.e DEMO-Yamaha-2023-1]
		String vehicleName = vehicle.getName();
		String brandName = getVehicleByBrand(vehicle);
		
		vehicle.setDate(new Date());
		String year = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));
		
		int idx = 0;
		String vehicleNumber = vehicleName + "-" + brandName + "-" + year + "-" + idx;

		vehicle.setVehicle_number(vehicleNumber);
		
		System.out.println(vehicleName);
		System.out.println(brandName);
		System.out.println(year);
		System.out.println(vehicleNumber);
		
		System.out.println(idx);	
		this.vehicleDao.save(vehicle);
	}
	
	public List<Vehicle> vehicleList() {
		return this.vehicleDao.getAll();
	}
	
	public Vehicle getVehcileById(Integer id) {
		return this.vehicleDao.getById(id);
	}
	
	public Vehicle getVehicleByVehicleNumber(String vehicleNumber) {
		List<Vehicle> list = vehicleList();
		for(Vehicle vehicle : list) {
			if(vehicle.getVehicle_number().equals(vehicleNumber)) {
				return vehicle;
			}
		}
		return null;
	}
	
	public void updateVehicle(Vehicle vehicle) {
		this.vehicleDao.update(vehicle);
	}
}

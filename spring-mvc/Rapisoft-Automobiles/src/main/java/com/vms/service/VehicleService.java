package com.vms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.VehicleDao;
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

		String vehicleName = vehicle.getName();
		String brandName = getVehicleByBrand(vehicle);

		vehicle.setCreatedAt(new Date());
		String year = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));

		int idx = 0;

		for (Vehicle vh : list) {
			if (vh.getShowroom().getBrand().getName().equals(brandName)) {
				idx++;
			}
		}

		String vehicleNumber = vehicleName + "-" + brandName + "-" + year + "-" + idx;

		vehicle.setVehicle_number(vehicleNumber);
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
		for (Vehicle vehicle : list) {
			if (vehicle.getVehicle_number().equals(vehicleNumber)) {
				return vehicle;
			}
		}
		return null;
	}
		
	public List<Vehicle> getVehicleAccordingToAvailability(Boolean isAvailable) {
		List<Vehicle> list = vehicleList();
		List<Vehicle> vehiclesList = new ArrayList<>();
		
		for(Vehicle vehicle: list) {
			if(vehicle.getIsAvailable().equals(isAvailable)) {
				vehiclesList.add(vehicle);
			}
		}
		return vehiclesList;
		
	}

	public void updateVehicle(Vehicle vehicle) {
		this.vehicleDao.update(vehicle);
	}

	public void updateVehicleStatus(Integer vehicleId) {
		Vehicle vehicle = getVehcileById(vehicleId);
		if (vehicle != null) {
			vehicle.setIsAvailable(false);
			this.vehicleDao.update(vehicle);
		}
	}
}

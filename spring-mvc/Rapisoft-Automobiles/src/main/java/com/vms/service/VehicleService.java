package com.vms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.util.MyEnum;
import com.vms.dao.VehicleDao;
import com.vms.dto.vehicle.ConvertVehicle;
import com.vms.dto.vehicle.VehicleDTO;
import com.vms.entity.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	public String getVehicleByBrand(Vehicle vehicle) {
		String str = this.vehicleDao.getByName(vehicle);
		return str;
	}

	public void saveVehicle(VehicleDTO vehicleDto) {

		Vehicle vehicle = ConvertVehicle.toVehicle(vehicleDto);
		System.out.println(vehicle.getPrice());

		List<Vehicle> list = this.vehicleDao.getAll();

		String vehicleName = vehicle.getName();
		String brandName = getVehicleByBrand(vehicle);

		vehicle.setCreatedAt(new Date());
		vehicle.setUpdatedAt(new Date());
//		String year = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));
//
//		int idx = 0;
//
//		for (Vehicle vh : list) {
//			if (vh.getShowroom().getBrand().getName().equals(brandName)) {
//				idx++;
//			}
//		}
//		String vehicleNumber = vehicleName + "-" + brandName + "-" + year + "-" + idx;
//
//		vehicle.setVehicleNumber(vehicleNumber);
		this.vehicleDao.save(vehicle);
	}

	public List<VehicleDTO> vehicleList() {
		List<Vehicle> list = this.vehicleDao.getAll();
		List<VehicleDTO> vehicleDtoList = list.stream().map(ConvertVehicle::toVehicleDTO).collect(Collectors.toList());
		return vehicleDtoList;
	}

	public Vehicle getVehcileById(Vehicle vehicle) {
		return this.vehicleDao.getById(vehicle);
		
	}

//	public VehicleDTO getVehicleByVehicleNumber(String vehicleNumber) {
//		List<VehicleDTO> list = vehicleList();
//		for (VehicleDTO vehicle : list) {
//			if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
//				return vehicle;
//			}
//		}
//		return null;
//	}

	public List<VehicleDTO> getVehicleDataDynamically(Integer showroomId, MyEnum vehicleType, Integer brandId) {

		List<VehicleDTO> vehicleList = vehicleList();

		List<VehicleDTO> dynamicSearchVehicleList = new ArrayList<>();

		if (showroomId != null && vehicleType != null && brandId != null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getShowroom().getId() == showroomId && vehicle.getVehicleType().equals(vehicleType)
						&& vehicle.getShowroom().getBrand().getId() == brandId) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		}

		else if (showroomId != null && vehicleType == null && brandId == null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getShowroom().getId() == showroomId) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		}

		else if (showroomId == null && vehicleType != null && brandId == null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getVehicleType().equals(vehicleType)) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		}

		else if (showroomId == null && vehicleType == null && brandId != null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getShowroom().getBrand().getId() == brandId) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		}

		else if (showroomId != null && vehicleType != null && brandId == null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getShowroom().getId() == showroomId && vehicle.getVehicleType().equals(vehicleType)) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		}

		else if (showroomId == null && vehicleType != null && brandId != null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getVehicleType().equals(vehicleType)
						&& vehicle.getShowroom().getBrand().getId() == brandId) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		}

		else if (showroomId != null && vehicleType == null && brandId != null) {
			for (VehicleDTO vehicle : vehicleList) {
				if (vehicle.getShowroom().getId() == showroomId
						&& vehicle.getShowroom().getBrand().getId() == brandId) {
					dynamicSearchVehicleList.add(vehicle);
				}
			}
		} else {
			return vehicleList;
		}

		return dynamicSearchVehicleList;
	}

	public List<VehicleDTO> getVehicleAccordingToAvailability(Boolean isAvailable) {
		List<VehicleDTO> list = vehicleList();
		List<VehicleDTO> vehiclesList = new ArrayList<>();

		for (VehicleDTO vehicle : list) {
			if (vehicle.getIsAvailable().equals(isAvailable)) {
				vehiclesList.add(vehicle);
			}
		}
		return vehiclesList;
	}

	public void updateVehicle(Vehicle vehicle) {
		this.vehicleDao.update(vehicle);
	}

	public void updateVehicleStatus(Vehicle vehicle) {
		Vehicle vehicleObj = this.vehicleDao.getById(vehicle);
		if (vehicleObj != null) {
			vehicleObj.setIsAvailable(false);
			vehicleObj.setUpdatedAt(new Date());
			this.vehicleDao.update(vehicleObj);
		}
	}
}

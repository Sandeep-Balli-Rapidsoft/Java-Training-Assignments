package com.vms.dto.vehicle;

import com.vms.entity.Vehicle;

public class ConvertVehicle {
	
	public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
		VehicleDTO vehicleDto = new VehicleDTO();
		vehicleDto.setName(vehicle.getName());
		vehicleDto.setEngine_code(vehicle.getEngine_code());
		vehicleDto.setChassis_number(vehicle.getChassis_number());
		vehicleDto.setVehicle_number(vehicle.getVehicle_number());
		vehicleDto.setCreatedAt(vehicle.getCreatedAt());
		vehicleDto.setUpdatedAt(vehicle.getUpdatedAt());
		vehicleDto.setPrice(vehicle.getPrice());
		vehicleDto.setIsAvailable(vehicle.getIsAvailable());
		vehicleDto.setShowroom(vehicle.getShowroom());
		vehicleDto.setVehicle_type(vehicle.getVehicle_type());
		
		return vehicleDto;
	}
	
	public static Vehicle toVehicle(VehicleDTO vehicleDto) {
		Vehicle vehicle = new Vehicle();
		vehicle.setName(vehicleDto.getName());
		vehicle.setEngine_code(vehicle.getEngine_code());
		vehicle.setChassis_number(vehicle.getChassis_number());
		vehicle.setVehicle_number(vehicle.getVehicle_number());
		vehicle.setCreatedAt(vehicle.getCreatedAt());
		vehicle.setUpdatedAt(vehicle.getUpdatedAt());
		vehicle.setPrice(vehicle.getPrice());
		vehicle.setIsAvailable(vehicleDto.getIsAvailable());
		vehicle.setShowroom(vehicleDto.getShowroom());
		vehicle.setVehicle_type(vehicleDto.getVehicle_type());
		
		return vehicle;
	}
}

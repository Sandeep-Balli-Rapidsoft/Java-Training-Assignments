package com.vms.dto.vehicle;

import com.vms.entity.Vehicle;

public class ConvertVehicle {
    
    public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
        VehicleDTO vehicleDto = new VehicleDTO();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setName(vehicle.getName());
        vehicleDto.setEngineCode(vehicle.getEngineCode());
        vehicleDto.setChassisNumber(vehicle.getChassisNumber());
        vehicleDto.setCreatedAt(vehicle.getCreatedAt());
        vehicleDto.setUpdatedAt(vehicle.getUpdatedAt());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setIsAvailable(vehicle.getIsAvailable());
        vehicleDto.setShowroom(vehicle.getShowroom());
        vehicleDto.setVehicleType(vehicle.getVehicleType());
        
        return vehicleDto;
    }
    
    public static Vehicle toVehicle(VehicleDTO vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId());
        vehicle.setName(vehicleDto.getName());
        vehicle.setEngineCode(vehicleDto.getEngineCode());
        vehicle.setChassisNumber(vehicleDto.getChassisNumber());
        vehicle.setCreatedAt(vehicleDto.getCreatedAt());
        vehicle.setUpdatedAt(vehicleDto.getUpdatedAt());
        vehicle.setPrice(vehicleDto.getPrice());
        vehicle.setIsAvailable(vehicleDto.getIsAvailable());
        vehicle.setShowroom(vehicleDto.getShowroom());
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        
        return vehicle;
    }
}

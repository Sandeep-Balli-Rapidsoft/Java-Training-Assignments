package com.vms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.VehicleDao;
import com.vms.dao.VehicleRegisterDao;
import com.vms.dto.register.ConvertRegister;
import com.vms.dto.register.RegisterDTO;
import com.vms.entity.Register;
import com.vms.entity.Vehicle;

@Service
public class VehicleRegisterService {

	@Autowired
	private VehicleRegisterDao vehicleRegisterDao;

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleDao vehicleDao;
	
	public void save(RegisterDTO registerDto) {
		
		Vehicle vehicle = this.vehicleService.getVehcileById(registerDto.getVehicle());
		List<Vehicle> list = this.vehicleDao.getAll();

		String vehicleName = vehicle.getName();
		String brandName = vehicle.getShowroom().getBrand().getName();
		List<Vehicle> specificBrand = new ArrayList<>();
		
		String year = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));

		int available = 0;

		for (Vehicle vh : list) {
			if (vh.getShowroom().getBrand().getName().equals(brandName)) {
				specificBrand.add(vh);
			}
		}
		
		for(Vehicle vh : specificBrand) {
			if(vh.getIsAvailable()) {
				available++;
			}
		}
		int curr = specificBrand.size() - available;
		
		String vehicleNumber = vehicleName + "-" + brandName + "-" + year + "-" + curr;
		System.out.println(vehicleNumber);
  
		registerDto.setVehicleNumber(vehicleNumber);	
		registerDto.setCreatedAt(new Date());
		registerDto.setUpdatedAt(new Date());
		Register register = ConvertRegister.toRegister(registerDto);
		this.vehicleService.updateVehicleStatus(vehicle);
		this.vehicleRegisterDao.save(register);
	
	}

	public RegisterDTO getById(Integer id) {
		Register register = this.vehicleRegisterDao.getById(id);
		RegisterDTO registerDto = ConvertRegister.toRegisterDTO(register);
		return registerDto;
	}

	public List<RegisterDTO> getAll() {
		List<Register> list = this.vehicleRegisterDao.getAll();
		List<RegisterDTO> registerDtoList = list.stream().map(ConvertRegister::toRegisterDTO).collect(Collectors.toList());
		return registerDtoList;
	}

	public List<RegisterDTO> getPurchaseHistoryByUserEmail(String email) {
		List<RegisterDTO> list = getAll();
		List<RegisterDTO> purchaseHistoryList = new ArrayList<>();

		for (RegisterDTO register : list) {
			if (register.getUser().getEmail().equals(email)) {
				purchaseHistoryList.add(register);
			}
		}
		return purchaseHistoryList;
	}

	public void update(RegisterDTO registerDto) {
		Register register = ConvertRegister.toRegister(registerDto);
		this.vehicleRegisterDao.update(register);
	}
}
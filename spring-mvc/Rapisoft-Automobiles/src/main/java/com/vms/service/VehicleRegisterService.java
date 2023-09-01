package com.vms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.VehicleRegisterDao;
import com.vms.dto.register.ConvertRegister;
import com.vms.dto.register.RegisterDTO;
import com.vms.dto.vehicle.ConvertVehicle;
import com.vms.dto.vehicle.VehicleDTO;
import com.vms.entity.Register;

@Service
public class VehicleRegisterService {

	@Autowired
	private VehicleRegisterDao vehicleRegisterDao;

	@Autowired
	private VehicleService vehicleService;

	public void save(RegisterDTO registerDto) {
		registerDto.setCreatedAt(new Date());
		registerDto.setUpdatedAt(new Date());
		Register register = ConvertRegister.toRegister(registerDto);
		
		this.vehicleService.updateVehicleStatus(register.getVehicle().getId());
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
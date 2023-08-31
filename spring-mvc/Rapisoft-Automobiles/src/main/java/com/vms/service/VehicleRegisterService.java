package com.vms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.VehicleRegisterDao;
import com.vms.entity.Register;
import com.vms.entity.Vehicle;

@Service
public class VehicleRegisterService {

	@Autowired
	private VehicleRegisterDao vehicleRegisterDao;

	@Autowired
	private VehicleService vehicleService;

	public void save(Register register) {
		register.setCreatedAt(new Date());
		register.setUpdatedAt(new Date());

		this.vehicleService.updateVehicleStatus(register.getVehicle().getId());

		this.vehicleRegisterDao.save(register);
	}

	public Register getById(Integer id) {
		Register register = this.vehicleRegisterDao.getById(id);
		return register;
	}

	public List<Register> getAll() {
		List<Register> list = this.vehicleRegisterDao.getAll();
		return list;
	}

	public List<Register> getPurchaseHistoryByUserEmail(String email) {
		List<Register> list = getAll();
		List<Register> purchaseHistoryList = new ArrayList<>();

		for (Register register : list) {
			if (register.getUser().getEmail().equals(email)) {
				purchaseHistoryList.add(register);
			}
		}
		return purchaseHistoryList;
	}

	public void update(Register register) {
		this.vehicleRegisterDao.update(register);
	}
}

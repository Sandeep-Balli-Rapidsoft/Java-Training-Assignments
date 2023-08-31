package com.vms.dao;

import java.util.List;

import com.vms.entity.Register;

public interface VehicleRegisterDao {

	public void save(Register register);

	public void update(Register register);

	public Register getById(Integer id);

	public List<Register> getAll();
}

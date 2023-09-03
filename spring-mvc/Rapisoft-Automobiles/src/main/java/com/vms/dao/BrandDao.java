package com.vms.dao;

import java.util.List;

import com.vms.entity.Brand;

public interface BrandDao {
	
	public void save(Brand brand);
	
	public void update(Integer id);
	
	public Brand getById(Brand brand);
	
	public List<Brand> getAll();
}

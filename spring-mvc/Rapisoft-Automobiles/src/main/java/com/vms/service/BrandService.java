package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.BrandDao;
import com.vms.entity.Brand;

@Service
public class BrandService {
	
	@Autowired
	private BrandDao brandDao;
	
	public void save(Brand brand) {
		this.brandDao.save(brand);
	}
	
	public List<Brand> getAll() {
		List<Brand> list = this.brandDao.getAll();
		try {
			if(!list.isEmpty() && list != null) {
				return list;
			} else {
				return null;
			}
		} catch (NullPointerException e) {
			e.getMessage();
		}
		return null;
	}
}

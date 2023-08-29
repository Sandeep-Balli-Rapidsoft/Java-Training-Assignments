package com.vms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.BrandDao;
import com.vms.entity.Brand;

@Service
public class BrandService {
	
	@Autowired
	private BrandDao brandDao;
	
	public void saveBrand(Brand brand) {
		this.brandDao.saveBrand(brand);
	}
}

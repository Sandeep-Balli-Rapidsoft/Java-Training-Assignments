package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.SubBrandDao;
import com.vms.entity.SubBrand;

@Service
public class SubBrandService {
	
	@Autowired
	private SubBrandDao subBrandDao;
	
	public void saveSubBrand(SubBrand subBrand) {
		this.subBrandDao.saveSubBrand(subBrand);
	}
	
	public List<SubBrand> subBrandList() {
		return this.subBrandDao.subBrandList();
	}
}

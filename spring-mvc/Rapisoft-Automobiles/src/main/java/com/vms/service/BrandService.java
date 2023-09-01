package com.vms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.BrandDao;
import com.vms.dto.brand.BrandDTO;
import com.vms.dto.brand.ConvertBrand;
import com.vms.entity.Brand;

@Service
public class BrandService {
	
	@Autowired
	private BrandDao brandDao;
	
	public void save(BrandDTO brandDto) {
		Brand brand = ConvertBrand.toBrand(brandDto);
		brand.setCreatedAt(new Date());
		brand.setUpdatedAt(new Date());
		this.brandDao.save(brand);
	}
	
	public List<BrandDTO> getAll() {
		List<Brand> list = this.brandDao.getAll();
		List<BrandDTO> brandDtoList = list.stream().map(ConvertBrand::toBrandDto).collect(Collectors.toList());
		try {
			if(!list.isEmpty() && list != null) {
				return brandDtoList;
			} else {
				return null;
			}
		} catch (NullPointerException e) {
			e.getMessage();
		}
		return null;
	}
}

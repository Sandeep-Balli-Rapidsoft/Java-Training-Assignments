package com.vms.dto.brand;

import com.vms.entity.Brand;

public class ConvertBrand {
	
	public static BrandDTO toBrandDto(Brand brand) {
		BrandDTO brandDto = new BrandDTO();
		brandDto.setId(brand.getId());
		brandDto.setName(brand.getName());
		brandDto.setEmail(brand.getEmail());
		brandDto.setCreatedAt(brand.getCreatedAt());
		brandDto.setUpdatedAt(brand.getUpdatedAt());
		
		return brandDto;
	}
	
	public static Brand toBrand(BrandDTO brandDto) {
		Brand brand = new Brand();
		brand.setName(brandDto.getName());
		brand.setEmail(brandDto.getEmail());
		brand.setCreatedAt(brandDto.getCreatedAt());
		brand.setUpdatedAt(brandDto.getUpdatedAt());
		
		return brand;
	}
}

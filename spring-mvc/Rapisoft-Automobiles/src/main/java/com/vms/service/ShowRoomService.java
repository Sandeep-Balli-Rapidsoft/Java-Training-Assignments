package com.vms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.ShowRoomDao;
import com.vms.dto.showroom.ConvertShowroom;
import com.vms.dto.showroom.ShowroomDTO;
import com.vms.entity.Brand;
import com.vms.entity.ShowRoom;

@Service
public class ShowRoomService {

	@Autowired
	private ShowRoomDao showRoomDao;
	
	@Autowired
	private BrandService brandService;

	public void saveShowRoom(ShowroomDTO showroomDto) {
		Brand brand = this.brandService.getById(showroomDto.getBrand());
		String address = showroomDto.getAddress();
		
		List<ShowroomDTO> showroomList = getAll();
		List<ShowroomDTO> inSamePlace = new ArrayList<>();
		
		for(ShowroomDTO showroomObj : showroomList) {
			if(showroomObj.getBrand().getName().equals(brand.getName())) {
				if(showroomObj.getAddress().equals(address)) {
					inSamePlace.add(showroomObj);
				}
			}
		}
		
		int idx = inSamePlace.size();
	
		String email = address.toLowerCase() + "."+ idx + "@" + brand.getName().toLowerCase() + ".com";
		
		showroomDto.setEmail(email);
		showroomDto.setCreatedAt(new Date());
		showroomDto.setUpdatedAt(new Date());
		ShowRoom showroom = ConvertShowroom.toShowRoom(showroomDto);
		this.showRoomDao.save(showroom);
	}

	public List<ShowroomDTO> getAll() {
		List<ShowRoom> list = this.showRoomDao.showRoomList();
		List<ShowroomDTO> showroomDtoList = list.stream().map(ConvertShowroom::toShowroomDto).collect(Collectors.toList());
		return showroomDtoList;
	}
	
	public List<ShowroomDTO> getShowroomByLocation(String location) {
		List<ShowroomDTO> list = getAll();
		List<ShowroomDTO> listOfShowrooms = new ArrayList<>();
		for(ShowroomDTO showroom : list) {
			if(showroom.getAddress().toLowerCase().equals(location.toLowerCase())) {
				listOfShowrooms.add(showroom);
			}
		}
		return listOfShowrooms;
	}
}

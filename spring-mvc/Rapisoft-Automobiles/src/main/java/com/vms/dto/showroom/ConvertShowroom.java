package com.vms.dto.showroom;

import com.vms.entity.ShowRoom;

public class ConvertShowroom {
	
	public static ShowroomDTO toShowroomDto(ShowRoom showroom) {
		ShowroomDTO showroomDto = new ShowroomDTO();
		showroomDto.setId(showroom.getId());
		showroomDto.setAddress(showroom.getAddress());
		showroomDto.setBrand(showroom.getBrand());
		showroomDto.setEmail(showroom.getEmail());
		showroomDto.setCreatedAt(showroom.getCreatedAt());
		showroomDto.setUpdatedAt(showroom.getUpdatedAt());
		showroomDto.setIsActive(showroom.getIsActive());
		
		return showroomDto;
	}
	
	public static ShowRoom toShowRoom(ShowroomDTO showroomDto) {
	    ShowRoom showroom = new ShowRoom();
	    showroom.setAddress(showroomDto.getAddress());
	    showroom.setBrand(showroomDto.getBrand());
	    showroom.setEmail(showroomDto.getEmail());
	    showroom.setCreatedAt(showroomDto.getCreatedAt());
	    showroom.setUpdatedAt(showroomDto.getUpdatedAt());
	    showroom.setIsActive(showroomDto.getIsActive());
	    
	    return showroom;
	}

}

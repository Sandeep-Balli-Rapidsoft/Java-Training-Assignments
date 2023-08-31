package com.vms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.ShowRoomDao;
import com.vms.entity.ShowRoom;

@Service
public class ShowRoomService {

	@Autowired
	private ShowRoomDao showRoomDao;

	public void saveShowRoom(ShowRoom showRoom) {
		this.showRoomDao.save(showRoom);
	}

	public List<ShowRoom> getAll() {
		List<ShowRoom> list = this.showRoomDao.showRoomList();
		return list;
	}
	
	public List<ShowRoom> getShowroomByLocation(String location) {
		List<ShowRoom> list = getAll();
		List<ShowRoom> listOfShowrooms = new ArrayList<>();
		for(ShowRoom showroom : list) {
			if(showroom.getAddress().toLowerCase().equals(location.toLowerCase())) {
				listOfShowrooms.add(showroom);
			}
		}
		return listOfShowrooms;
	}
}

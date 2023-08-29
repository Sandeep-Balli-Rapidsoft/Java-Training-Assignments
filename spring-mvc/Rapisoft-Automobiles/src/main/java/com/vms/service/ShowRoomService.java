package com.vms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.ShowRoomDao;
import com.vms.entity.ShowRoom;

@Service
public class ShowRoomService {
	
	@Autowired
	private ShowRoomDao showRoomDao;
	
	public void saveShowRoom(ShowRoom showRoom) {
		this.showRoomDao.saveShowRoom(showRoom);
	}
}

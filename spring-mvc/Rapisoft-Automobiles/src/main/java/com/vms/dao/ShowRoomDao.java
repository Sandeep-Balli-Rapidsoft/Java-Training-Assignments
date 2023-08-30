package com.vms.dao;

import java.util.List;

import com.vms.entity.ShowRoom;

public interface ShowRoomDao {
	
	
	public void save(ShowRoom showRoom);
	
	public void update();
	
	public ShowRoom getShowRoom(Integer id);
	
	public List<ShowRoom> showRoomList();
}

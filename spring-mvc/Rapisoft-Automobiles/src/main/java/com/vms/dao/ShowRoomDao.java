package com.vms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.entity.ShowRoom;

@Repository
@Transactional
public class ShowRoomDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveShowRoom(ShowRoom showRoom) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(showRoom);
	}
}

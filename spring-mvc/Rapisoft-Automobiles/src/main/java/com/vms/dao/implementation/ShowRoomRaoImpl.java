package com.vms.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.dao.ShowRoomDao;
import com.vms.entity.ShowRoom;

@Repository
@Transactional
public class ShowRoomRaoImpl implements ShowRoomDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ShowRoom showRoom) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(showRoom);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShowRoom getShowRoom(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowRoom> showRoomList() {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<ShowRoom> list = currentSession.createQuery("FROM ShowRoom", ShowRoom.class).getResultList();
		return list;
	}
	
	public void saveShowRoom(ShowRoom showRoom) {
		
	}
}

package com.vms.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.dao.VehicleRegisterDao;
import com.vms.entity.Register;

@Repository
@Transactional
public class VehicleRegisterDaoImpl implements VehicleRegisterDao {
	

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Register register) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(register);
		
	}

	@Override
	public void update(Register register) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Register registerObj = currentSession.get(Register.class, register.getId());
		currentSession.saveOrUpdate(registerObj);
		
	}

	@Override
	public Register getById(Integer id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Register registerObj = currentSession.get(Register.class, id);
		return registerObj;
	}

	@Override
	public List<Register> getAll() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		String query = "FROM Register";
		List<Register> list = currentSession.createQuery(query, Register.class).getResultList();
		return list;
	}

}

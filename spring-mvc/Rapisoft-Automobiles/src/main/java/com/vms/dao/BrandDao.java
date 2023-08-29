package com.vms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.entity.Brand;

@Repository
@Transactional
public class BrandDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveBrand(Brand brand) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(brand);
	}

}

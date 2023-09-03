package com.vms.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.dao.BrandDao;
import com.vms.entity.Brand;

@Repository
@Transactional
public class BrandDaoImpl implements BrandDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Brand brand) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(brand);
		
	}

	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Brand getById(Brand brand) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		Brand brandObj = currentSession.get(Brand.class, brand.getId());
		return brandObj;
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		String query = "From Brand";
		List<Brand> list = currentSession.createQuery(query, Brand.class).getResultList();
		return list;
	}
}
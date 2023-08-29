package com.vms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.entity.SubBrand;

@Repository
@Transactional
public class SubBrandDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveSubBrand(SubBrand subBrand) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(subBrand);
	}
	
	public List<SubBrand> subBrandList() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		String query = "From SubBrand";
		List<SubBrand> list = currentSession.createQuery(query, SubBrand.class).getResultList();
		return list;
	}
}

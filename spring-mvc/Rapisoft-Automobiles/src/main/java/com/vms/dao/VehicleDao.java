package com.vms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.entity.Vehicle;

@Repository
@Transactional
public class VehicleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveVehicle(Vehicle vehicle) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(vehicle);
	}
	
	public List<Vehicle> vehicleList() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		String query = "FROM Vehicle";
		List<Vehicle> list = currentSession.createQuery(query, Vehicle.class).getResultList();
		return list;
	}
}

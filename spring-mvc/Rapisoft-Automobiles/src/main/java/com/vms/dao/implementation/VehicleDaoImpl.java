package com.vms.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.dao.VehicleDao;
import com.vms.entity.ShowRoom;
import com.vms.entity.Vehicle;

@Repository
@Transactional
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(vehicle);
	}

	@Override
	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(vehicle);

	}

	@Override
	public Vehicle getById(Integer id) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		Vehicle vehicle = currentSession.get(Vehicle.class, id);
		return vehicle;
	}

	@Override
	public List<Vehicle> getAll() {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		String query = "FROM Vehicle";
		List<Vehicle> list = currentSession.createQuery(query, Vehicle.class).getResultList();
		return list;
	}

	@Override
	public String getByName(Vehicle vehicle) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		ShowRoom showroom = currentSession.get(ShowRoom.class, vehicle.getShowroom().getId());
		if(showroom != null) {
			return showroom.getBrand().getName();
		}
		return null;
	}

}

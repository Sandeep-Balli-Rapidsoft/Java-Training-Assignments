package com.DeveloperEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ManagerEntity.Manager;

@Entity
@Table(name = "developer")
public class Developer {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	private String developer_name;
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeveloper_name() {
		return developer_name;
	}

	public void setDeveloper_name(String developer_name) {
		this.developer_name = developer_name;
	}

	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developer(Integer id) {
		super();
		this.id = id;
	}

	
	
	
}

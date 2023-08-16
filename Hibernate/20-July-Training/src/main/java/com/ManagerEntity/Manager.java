package com.ManagerEntity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.DeveloperEntity.Developer;
import com.QAEntity.QualityAnalyst;

@Entity
@Table(name = "manager")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String manager_name;

	public Integer getId() {
		return id;
	}

	@OneToMany(mappedBy = "manager")
	private List<Developer> developer;
	
	public List<Developer> getDeveloper() {
		return developer;
	}

	public void setDeveloper(List<Developer> developer) {
		this.developer = developer;
	}

	public List<QualityAnalyst> getQualityAnalyst() {
		return qualityAnalyst;
	}

	public void setQualityAnalyst(List<QualityAnalyst> qualityAnalyst) {
		this.qualityAnalyst = qualityAnalyst;
	}

	@OneToMany(mappedBy = "manager")
	private List<QualityAnalyst> qualityAnalyst;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer id) {
		super();
		this.id = id;
	}
	
	
}

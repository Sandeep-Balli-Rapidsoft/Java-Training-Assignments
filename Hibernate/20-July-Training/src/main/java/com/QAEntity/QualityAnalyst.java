package com.QAEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ManagerEntity.Manager;

@Entity
@Table(name = "quality_analyst")
public class QualityAnalyst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String qa_name;
	
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

	public String getQa_name() {
		return qa_name;
	}

	public void setQa_name(String qa_name) {
		this.qa_name = qa_name;
	}

	public QualityAnalyst(Integer id) {
		super();
		this.id = id;
	}

	public QualityAnalyst() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Subject;

@Transactional
@Component("subjectDao")
public class SubjectDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int insert(Subject subject) {
		Integer result = (Integer) this.hibernateTemplate.save(subject);
		return result;
	}
	
	public List<Subject> subjectList() {
		List<Subject> subjectList = this.hibernateTemplate.loadAll(Subject.class);
		return subjectList;
	}

}

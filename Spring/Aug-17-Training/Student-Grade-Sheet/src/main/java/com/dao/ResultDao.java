package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Result;

@Transactional
@Component("resultDao")
public class ResultDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int insert(Result result) {
		Integer r = (Integer) this.hibernateTemplate.save(result);
		return r;
	}
	
	public List<Result> resultList() {
		List<Result> list = this.hibernateTemplate.loadAll(Result.class);
		return list;
	}
}

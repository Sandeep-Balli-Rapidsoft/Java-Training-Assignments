package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Employee;

@Component("getEmployeeDAO")
public class EmployeeDaoImplementation implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Employee employee) {
		String query = "INSERT INTO employee_table(id, name, age, dept) values(?, ?, ?, ?)";
		int result = this.jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getAge(),
				employee.getDept());
		return result;
	}

	public int update(Employee employee) {
		String query = "Update employee_table SET name = ?, age = ?, dept = ? where id = ?";
		int result = this.jdbcTemplate.update(query, employee.getName(), employee.getAge(), employee.getDept(),
				employee.getId());
		return result;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> list = this.jdbcTemplate.query("Select * from employee_table", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAge(rs.getInt(3));
				employee.setDept(rs.getString(4));
				return employee;
			}

		});
		return list;
	}

	public Employee getEmployeById(Integer id) {
		String query = "Select * from employee_table where id = ?";
		@SuppressWarnings("deprecation")
		Employee employee = this.jdbcTemplate.queryForObject(query, new Object[] { id }, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAge(rs.getInt(3));
				emp.setDept(rs.getString(4));
				return emp;
			}

		});
		return employee;
	}

	public int deleteEmployee(Integer id) {
		String query = "DELETE FROM employee_table where id = ?";
		int result = this.jdbcTemplate.update(query, new Object[] { id });
		return result;
	}

}

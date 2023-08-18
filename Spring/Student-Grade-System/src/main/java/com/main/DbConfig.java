package com.main;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.dao" })
public class DbConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/student_grade_sheet");
		ds.setUsername("root");
		ds.setPassword("password");
		return ds;
	}

	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBean localFactory = new LocalSessionFactoryBean();
		localFactory.setDataSource(getDataSource());
		localFactory.setHibernateProperties(getHibernateProperties());
		localFactory.setPackagesToScan("com.entities");
		try {
			localFactory.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localFactory.getObject();
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		return properties;
	}

	@Bean
	public HibernateTemplate getHibernateTemplate() {
		return new HibernateTemplate(getSessionFactory());
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(getSessionFactory());
	}
}

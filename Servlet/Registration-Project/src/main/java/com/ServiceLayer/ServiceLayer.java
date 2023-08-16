package com.ServiceLayer;

import java.util.List;

import com.UserDAO.UserDAO;
import com.UserEntity.User;

public class ServiceLayer {
	
	public static boolean isInsertedData(User user) {
		return UserDAO.insertUser(user);
	}
	
	public static User login(String email, String password) {
		return UserDAO.login(email, password);
	}
	
	public static List<User> getAllColleagues() {
		List<User> colleaguesList = UserDAO.getColleagues();

		return colleaguesList;
	}
	
}

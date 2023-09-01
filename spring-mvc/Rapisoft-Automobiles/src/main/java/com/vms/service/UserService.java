package com.vms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.UserDao;
import com.vms.dto.user.ConvertUser;
import com.vms.dto.user.UserDTO;
import com.vms.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void saveUser(UserDTO userDTO) {
		List<UserDTO> list = getAllUsers();
		
		for(UserDTO user : list) {
			if(user.getEmail().equals(userDTO.getEmail())) {
				System.out.println("Already exists");
				return;
			}
		}
		
		User user = ConvertUser.toUser(userDTO);
		this.userDao.save(user);
		
	}
	
	public List<UserDTO> getAllUsers() {
		List<User> list = this.userDao.userList();
		List<UserDTO> userDtoList = list.stream().map(ConvertUser::toUserDto).collect(Collectors.toList());

		return userDtoList;
	}
	
	public UserDTO getUser(Integer id) {
		UserDTO userDto = ConvertUser.toUserDto(this.userDao.getUser(id));
		if(userDto != null) {
			return userDto;
		}
		return null;
	}
	
	
}

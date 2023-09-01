package com.vms.dto.user;

import com.vms.entity.User;

public class ConvertUser {
	
	public static UserDTO toUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPhone(user.getPhone());
		userDto.setAddress(user.getAddress());
		
		return userDto;
	}
	
	public static User toUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setAddress(userDTO.getAddress());
		return user;
	}
}

package com.vms.dto.user;

import org.modelmapper.ModelMapper;

import com.vms.entity.User;

public class ConvertUser {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static UserDTO toUserDto(User user) {		
		return modelMapper.map(user, UserDTO.class);
	}
	
	public static User toUser(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
}

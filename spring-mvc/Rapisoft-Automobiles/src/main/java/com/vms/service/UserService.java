package com.vms.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.util.Response;
import com.vms.dao.UserDao;
import com.vms.dto.user.ConvertUser;
import com.vms.dto.user.UserDTO;
import com.vms.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public Response<?> saveUser(UserDTO userDto) {
		List<UserDTO> list = getAllUsers();

		try {
			for (UserDTO user : list) {
				if (user.getEmail().equals(userDto.getEmail())) {
					return new Response<UserDTO>("Already Exists", user, HttpStatus.BAD_REQUEST);
				}
			}
			userDto.setCreatedAt(new Date());
			userDto.setUpdatedAt(new Date());

			User user = ConvertUser.toUser(userDto);
			this.userDao.save(user);
			return new Response<User>("User Created Successfully", user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new Response<String>(msg, null, HttpStatus.BAD_REQUEST);
		}
	}

	public List<UserDTO> getAllUsers() {
		List<User> list = this.userDao.userList();
		List<UserDTO> userDtoList = list.stream().map(ConvertUser::toUserDto).collect(Collectors.toList());

		return userDtoList;
	}

	public UserDTO getUser(Integer id) {
		UserDTO userDto = ConvertUser.toUserDto(this.userDao.getUser(id));
		if (userDto != null) {
			return userDto;
		}
		return null;
	}

}

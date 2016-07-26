package com.joyful.service.user;

import com.joyful.entity.user.UserEntity;

public interface IUserService {
	
	public UserEntity getUserById(String userId);
	
	public int userInsert(UserEntity user);
}

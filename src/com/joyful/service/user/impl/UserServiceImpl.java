package com.joyful.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyful.dao.user.UserDao;
import com.joyful.entity.user.UserEntity;
import com.joyful.service.user.IUserService;



@Service("userService")  
public class UserServiceImpl implements IUserService {
	@Autowired
    private UserDao userDao; 
	
	@Override
	public UserEntity getUserById(String userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional
	public int userInsert(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

}

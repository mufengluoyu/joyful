package com.joyful.dao.user;

import com.joyful.common.annotation.MyBatisDao;
import com.joyful.entity.user.UserEntity;

@MyBatisDao
public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}
package com.mirkmoon.mapper;

import com.mirkmoon.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);


    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);

    Optional<User> queryByUsernameOrEmailOrPhone(String username, String email, String phone);

    List<User> findByUsernameIn(List<String> usernameList);
}
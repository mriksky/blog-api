package com.mirkmoon.mapper;

import com.mirkmoon.pojo.unionkey.UserRoleKey;

public interface UserRoleMapper {

    int deleteByPrimaryKey(UserRoleKey key);


    int insert(UserRoleKey record);


    int insertSelective(UserRoleKey record);
}
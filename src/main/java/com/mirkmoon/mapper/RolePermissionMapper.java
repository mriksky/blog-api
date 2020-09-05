package com.mirkmoon.mapper;

import com.mirkmoon.pojo.unionkey.RolePermissionKey;

public interface RolePermissionMapper {

    int deleteByPrimaryKey(RolePermissionKey key);


    int insert(RolePermissionKey record);


    int insertSelective(RolePermissionKey record);
}
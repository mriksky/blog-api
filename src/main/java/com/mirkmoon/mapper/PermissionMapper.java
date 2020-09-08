package com.mirkmoon.mapper;

import com.mirkmoon.pojo.Permission;

import java.util.List;

public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);


    int insert(Permission record);


    int insertSelective(Permission record);


    Permission selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Permission record);


    int updateByPrimaryKey(Permission record);

    List<Permission> selectByRoleIdList(List<Long> ids);

}
package com.lzwing.mybatisspringxmldemo.mapper;

import com.lzwing.mybatisspringxmldemo.entity.MyUser;

public interface MyUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(MyUser record);

    int insertSelective(MyUser record);

    MyUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(MyUser record);

    int updateByPrimaryKey(MyUser record);
}
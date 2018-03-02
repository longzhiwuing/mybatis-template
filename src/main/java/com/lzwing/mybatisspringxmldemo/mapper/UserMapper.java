package com.lzwing.mybatisspringxmldemo.mapper;

import com.lzwing.mybatisspringxmldemo.entity.User;

import java.util.List;

//@Mapper
public interface UserMapper {

    int save(User user);

    User selectById(Integer id);

    int updateById(User user);

    int deleteById(Integer id);

    List<User> queryAll();

} 
package com.hust.dao;

import com.hust.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository二者作用等同,前者在应用mybatis时使用较多
public interface UserMapper {

    //查询
    List<User> selectAll();

    User selectById(int id);

    User selectByName(String name);

    User selectByEmail(String Email);

    //添加
    int insertUser(User user);

    //修改
    int updateStatus(int id, int status);

    int updateHeaderUrl(int id, String headerUrl);

    int updatePassword(int id, String password);

}

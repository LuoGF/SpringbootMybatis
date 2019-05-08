package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper         //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserMapper {

    List<User> getAllUser();
    @Select("select name,id from user where name=#{name}")
    User getAllUserByName(@Param("name") String name);
    User loginPage(String name,String id);
}
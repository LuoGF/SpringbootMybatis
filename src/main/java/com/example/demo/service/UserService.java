package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getAllUserByName(String name);
    User loginPage(String name,String id);
}

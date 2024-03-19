package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserDao 
{
public User findExist(User user);
public String register(User user);
public String login(User user);
public List<User> show();
}

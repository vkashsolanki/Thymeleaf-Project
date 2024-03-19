package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserDaoImpl implements UserDao
{
    @Autowired
	private UserRepo repo;
	
    
    @Override
	public User findExist(User user) 
    {
		User user2=repo.findByEmailOrMobile(user.getEmail(), user.getMobile());
		System.out.println(user2);
		return user2;
	}
    
    @Transactional
	@Override
	public String register(User user)
	{
		User user2=this.findExist(user);
		if(user2!=null)
		{
			return "Email or mobile already exists";
		}
		else
		{
			repo.save(user);
			return "Registration Successfull";
		}
	}

	@Override
	public String login(User user)
	{
		User user2=repo.findByEmailAndPass(user.getEmail(), user.getPass());
		System.out.println("Login = "+user2);
		if(user2!=null)
		{
			return "Login Successfull";
		}
		else
		{
			return "Invalid username and password";
		}
	}

	@Override
	public List<User> show() 
	{
		List<User> list=repo.findAll();
		return list;
	}


	
}

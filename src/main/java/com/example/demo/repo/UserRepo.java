package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
public User findByEmailOrMobile(String email,String mobile);
public User findByEmailAndPass(String email,String pass);
}

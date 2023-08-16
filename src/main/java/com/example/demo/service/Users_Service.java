package com.example.demo.service;

import com.example.demo.dto.Users_Request;
import com.example.demo.entity.Users;
import com.example.demo.exception.UserNotFoundException;
import org.apache.catalina.User;

import java.util.List;

public interface Users_Service {
    public Users saveUser(Users_Request usersRequest);
    public List<Users> getalluser();
    public Users getUserByID(int id);
    public Users getuser(int id) throws UserNotFoundException;
}

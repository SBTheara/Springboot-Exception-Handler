package com.example.demo.service.implement;

import com.example.demo.dto.Users_Request;
import com.example.demo.entity.Users;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.Users_Repository;
import com.example.demo.service.Users_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Users_Implement implements Users_Service {
    @Autowired
    private Users_Repository usersRepository;
    @Override
    public Users saveUser(Users_Request usersRequest) {
        Users user = Users.build(0,usersRequest.getName(),usersRequest.getEmail(),usersRequest.getMobile(),
                usersRequest.getGender(),usersRequest.getAge(),usersRequest.getNationality());
        return usersRepository.save(user);
    }

    @Override
    public List<Users> getalluser() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserByID(int id) {
        return usersRepository.findById(id).get()       ;
    }

    @Override
    public Users getuser(int id) throws UserNotFoundException {
        Users user = usersRepository.findById(id).get();
        if(user!= null){
            return user;
        }else{
            throw new UserNotFoundException("Not found for user with this id: "+id);
        }
    }
}

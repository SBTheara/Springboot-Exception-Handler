package com.example.demo.controller;

import com.example.demo.dto.Users_Request;
import com.example.demo.entity.Users;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.Users_Service;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class Users_Controller {
    @Autowired
    private Users_Service usersService;

    @PostMapping(value = "/post")
    public ResponseEntity<Users> saveUser(@RequestBody @Valid Users_Request usersRequest){//use @valid for make spring know the annotation for handle exception tha we make on Users_request class
        return new ResponseEntity<Users>(usersService.saveUser(usersRequest),HttpStatus.CREATED);
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<List<Users>> getalluser(){
        return new ResponseEntity<>(usersService.getalluser(),HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Users> getByID(@PathVariable(name = "id") int id) throws UserNotFoundException {
        return new ResponseEntity<>(usersService.getuser(id),HttpStatus.OK);
    }
}

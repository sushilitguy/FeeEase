package com.softmania.FeeEase.controller.rest;

import com.softmania.FeeEase.model.Users;
import com.softmania.FeeEase.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fee_ease/api/")
public class UsersController {
    @Autowired
    private UsersService service;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> users = service.getUsers();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Users user = service.getUserById(id);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users addedUser = service.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @PatchMapping("/users/enable/{id}")
    public ResponseEntity<Users> enableUser(@PathVariable int id) {
        Users enabledUser = service.enableUser(id);
        if(enabledUser != null) {
            return new ResponseEntity<>(enabledUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/users/disable/{id}")
    public ResponseEntity<Users> disableUser(@PathVariable int id) {
        Users disabledUser = service.disableUser(id);
        if(disabledUser != null) {
            return new ResponseEntity<>(disabledUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users")
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        Users updatedUser = service.updateUser(user);
        if(updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

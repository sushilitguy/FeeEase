package com.softmania.FeeEase.service;

import com.softmania.FeeEase.model.UserData;
import com.softmania.FeeEase.model.Users;
import com.softmania.FeeEase.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepo repo;
//    @Autowired
//    private AuthenticationManager authManager;
//    @Autowired
//    private JWTService jwtService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<Users> getUsers() {
        return repo.findAll();
    }

    public Users getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Users addUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public Users enableUser(int id) {
        Users enabledUser = null;
        Users existingUser = getUserById(id);
        if(existingUser != null) {
            existingUser.setEnabled(true);
            enabledUser = repo.save(existingUser);
        }
        return enabledUser;
    }

    public Users disableUser(int id) {
        Users disabledUser = null;
        Users existingUser = getUserById(id);
        if(existingUser != null) {
            existingUser.setEnabled(false);
            disabledUser = repo.save(existingUser);
        }
        return disabledUser;
    }

    public Users updateUser(Users user) {
        Users updatedUser = null;
        if(repo.existsById(user.getId())) {
            updatedUser = repo.save(user);
        }
        return updatedUser;
    }
}
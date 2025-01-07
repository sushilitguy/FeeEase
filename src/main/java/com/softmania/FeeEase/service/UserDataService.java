package com.softmania.FeeEase.service;

import com.softmania.FeeEase.model.UserData;
import com.softmania.FeeEase.model.Users;
import com.softmania.FeeEase.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements UserDetailsService {
    @Autowired
    private UsersRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUserName(username);
        if(user == null) {
            System.out.println("User : " + username + " not found in database");
            throw new UsernameNotFoundException("User : " + username + " not found in database");
        }
        return new UserData(user);
    }
}
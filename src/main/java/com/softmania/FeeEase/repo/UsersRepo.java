package com.softmania.FeeEase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.softmania.FeeEase.model.Users;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUserName(String username);
}

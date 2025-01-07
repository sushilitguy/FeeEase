package com.softmania.FeeEase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softmania.FeeEase.model.FeeType;

@Repository
public interface FeeTypeRepo extends JpaRepository<FeeType, Integer>{
}

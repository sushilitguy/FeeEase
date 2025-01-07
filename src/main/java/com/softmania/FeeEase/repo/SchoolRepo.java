package com.softmania.FeeEase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softmania.FeeEase.model.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Integer> {
}

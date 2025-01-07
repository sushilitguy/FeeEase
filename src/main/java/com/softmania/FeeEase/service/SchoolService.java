package com.softmania.FeeEase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softmania.FeeEase.model.School;
import com.softmania.FeeEase.repo.SchoolRepo;

@Service
public class SchoolService {
	@Autowired
	private SchoolRepo repo;

	public School registerSchool(School school) {
		return repo.save(school);
	}

	public School updateSchool(School school) {
		if(repo.existsById(school.getId())) {
			return repo.save(school);
		} else {
			return null;
		}
	}

	public School getSchoolBySchoolId(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<School> getSchools() {
		return repo.findAll();
	}
}
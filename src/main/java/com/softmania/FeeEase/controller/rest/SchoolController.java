package com.softmania.FeeEase.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softmania.FeeEase.model.School;
import com.softmania.FeeEase.service.SchoolService;

@RestController
@CrossOrigin
@RequestMapping("/fee_ease/api/")
public class SchoolController {
	@Autowired
	private SchoolService service;
	
	@PostMapping("/school")
	public ResponseEntity<School> registerSchool(@RequestBody School school){
		School addedSchool = service.registerSchool(school);
		return new ResponseEntity<>(addedSchool, HttpStatus.OK);
	}
	
	@PutMapping("/school")
	public ResponseEntity<School> updateSchool(@RequestBody School school){
		School updatedSchool = service.updateSchool(school);
		if(updatedSchool != null) {
			return new ResponseEntity<>(updatedSchool, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/school/{id}")
	public ResponseEntity<School> getSchoolBySchoolId(int id) {
		School school = service.getSchoolBySchoolId(id);
		if(school != null) {
			return new ResponseEntity<>(school, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/school")
	public ResponseEntity<List<School>> getSchools() {
		List<School> schools = service.getSchools();
		if(!schools.isEmpty()) {
			return new ResponseEntity<>(schools,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}

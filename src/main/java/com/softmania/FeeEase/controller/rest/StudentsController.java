package com.softmania.FeeEase.controller.rest;

import com.softmania.FeeEase.model.Students;
import com.softmania.FeeEase.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fee_ease/api/")
public class StudentsController {
    @Autowired
    private StudentsService service;

    @GetMapping("/students")
    public ResponseEntity<List<Students>> getStudents() {
        List<Students> students = service.getStudents();
        if(students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    @GetMapping("/students/session/{session}")
    public ResponseEntity<List<Students>> getStudentsBySession(@PathVariable String session) {
        List<Students> students = service.getStudentsBySession(session);
        if(students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    @GetMapping("/students/session/{session}/class/{schoolClass}")
    public ResponseEntity<List<Students>> getStudentsBySessionAndClass(@PathVariable String session, @PathVariable String schoolClass) {
        List<Students> students = service.getStudentsBySessionAndClass(session, schoolClass);
        if(students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable int id) {
        Students student = service.getStudentById(id);
        if(student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<Students> addStudent(@RequestBody Students student) {
        Students addedStudent = service.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.OK);
    }

    @PutMapping("/students")
    public ResponseEntity<Students> updateStudent(@RequestBody Students student) {
        Students updatedStudent = service.updateStudent(student);
        if(updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/students/enable/{id}")
    public ResponseEntity<Students> enableStudent(@PathVariable int id) {
        Students enabledStudent = service.enableStudent(id);
        if(enabledStudent != null) {
            return new ResponseEntity<>(enabledStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/students/disable/{id}")
    public ResponseEntity<Students> disableStudent(@PathVariable int id) {
        Students disabledStudent = service.disableStudent(id);
        if(disabledStudent != null) {
            return new ResponseEntity<>(disabledStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
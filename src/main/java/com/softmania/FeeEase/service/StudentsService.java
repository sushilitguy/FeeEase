package com.softmania.FeeEase.service;

import com.softmania.FeeEase.model.Students;
import com.softmania.FeeEase.repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepo repo;

    public List<Students> getStudents() {
        return repo.findAll();
    }

    public Students getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Students getStudentsBySession(String session) {
        return repo.findBySession(session);
    }

    public Students getStudentsBySessionAndClass(String session, String schoolClass) {
        return repo.findBySessionAndSchoolClass(session, schoolClass);
    }

    public Students addStudent(Students student) {
        return repo.save(student);
    }

    public Students updateStudent(Students student) {
        Students updatedStudent = null;
        if(repo.existsById(student.getId())) {
            updatedStudent = repo.save(student);
        }
        return updatedStudent;
    }

    public Students enableStudent(int id) {
        Students enabledStudent = null;
        Students existingStudent = getStudentById(id);
        if(existingStudent != null) {
            existingStudent.setEnabled(true);
            enabledStudent = repo.save(existingStudent);
        }
        return enabledStudent;
    }

    public Students disableStudent(int id) {
        Students disabledStudent = null;
        Students existingStudent = getStudentById(id);
        if(existingStudent != null) {
            existingStudent.setEnabled(false);
            disabledStudent = repo.save(existingStudent);
        }
        return disabledStudent;
    }

    public List<Students> getFeesNotPaidByStudentByMonthYear(int schoolId, String depositMonthYear) {
        return repo.getFeesNotPaidByStudentByMonthYear(schoolId, depositMonthYear);
    }
}
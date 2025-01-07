package com.softmania.FeeEase.controller.rest;

import com.softmania.FeeEase.model.Fees;
import com.softmania.FeeEase.model.Students;
import com.softmania.FeeEase.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fee_ease/api/")
public class FeesController {
    private FeesService service;

    @Autowired
    public FeesController(FeesService service) {
        this.service = service;
    }

    @GetMapping("/fees/paid/year/{year}/schoolid/{schoolId}")
    public ResponseEntity<List<Fees>> getFeesPaidByYear(@PathVariable int year, @PathVariable int schoolId) {
        List<Fees> feesPaid = service.getFeesPaidByYear(year, schoolId);
        if(!feesPaid.isEmpty()) {
            return new ResponseEntity<>(feesPaid, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/fees/paid/month-year/{depositMonthYear}/schoolid/{schoolId}")
    public ResponseEntity<List<Fees>> getFeesPaidByMonthYear(@PathVariable int schoolId, @PathVariable String depositMonthYear) {
        List<Fees> feesPaid = service.getFeesPaidByMonthYear(schoolId, depositMonthYear);
        if(!feesPaid.isEmpty()) {
            return new ResponseEntity<>(feesPaid, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/fees/paid/studentid/{studentId}/schoolid/{schoolId}")
    public ResponseEntity getFeesPaidByStudent(@PathVariable int schoolId, @PathVariable int studentId) {
        List<Fees> feesPaid = null;
        try {
            feesPaid = service.getFeesPaidByStudent(schoolId, studentId);
            if(!feesPaid.isEmpty()) {
                return new ResponseEntity<>(feesPaid, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/fees/unpaid/month-year/{depositMonthYear}/schoolid/{schoolId}/")
    public ResponseEntity<List<Students>> getFeesNotPaidByStudentByMonthYear(@PathVariable int schoolId, @PathVariable String depositMonthYear) {
        List<Students> Students = service.getFeesNotPaidByStudentByMonthYear(schoolId, depositMonthYear);
        if(!Students.isEmpty()) {
            return new ResponseEntity<>(Students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/fees")
    public ResponseEntity addFees(@RequestBody Fees fees) {
        Fees addedFees = null;
        try {
            addedFees = service.addFees(fees);
            return new ResponseEntity<>(addedFees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/fees")
    public ResponseEntity<Fees> updateFees(@RequestBody Fees fees) {
        Fees updatedFees = service.updateFees(fees);
        if(updatedFees != null) {
            return new ResponseEntity<>(updatedFees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
package com.softmania.FeeEase.controller.rest;

import com.softmania.FeeEase.model.FeeType;
import com.softmania.FeeEase.service.FeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fee_ease/api/")
public class FeeTypeController {
    @Autowired
    private FeeTypeService service;

    @GetMapping("/feetype")
    public ResponseEntity<List<FeeType>> getFeeTypes(){
        List<FeeType> feeTypes = service.getFeeTypes();
        if(!feeTypes.isEmpty()) {
            return new ResponseEntity<>(feeTypes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/feetype/{id}")
    public ResponseEntity<FeeType> getFeeTypesById(@PathVariable int id) {
        FeeType feeType = service.getFeeTypeById(id);
        if(feeType != null) {
            return new ResponseEntity<>(feeType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/feetype")
    public ResponseEntity<FeeType> addFeeType(@RequestBody FeeType feeType) {
        FeeType addedFeeType = service.addFeeType(feeType);
        return new ResponseEntity<>(addedFeeType, HttpStatus.CREATED);
    }

    @PutMapping("/feetype")
    public ResponseEntity<FeeType> updateFeeType(@RequestBody FeeType feeType) {
        FeeType updatedFeeType = service.updateFeeType(feeType);
        if(updatedFeeType != null) {
            return new ResponseEntity<>(updatedFeeType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feeType")
    public ResponseEntity deleteFeeType(int id) {
        boolean isDeleted = service.deleteFeeType(id);
        if(isDeleted) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FeeType not found", HttpStatus.NOT_FOUND);
        }
    }
}
package com.patient.app.controller;

import com.patient.app.model.Patient;
import com.patient.app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    //Create --> insert data of patient
    @PostMapping("/patient")
    private String insertNewPatient(@RequestBody Patient patient){
        return patientService.insertNewPatient(patient);
    }

    //Get --> get all patients
    @GetMapping("/patients")
    private List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    //Get ---> fetch patient by id
    @GetMapping("/patient/{patientId}")
    private Object getPatientById(@PathVariable int patientId){
        try{
            return patientService.getPatientById(patientId);
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

    //Update ---> update patient by id
    @PutMapping("/patient/{patientId}")
    private String updatePatientById(@PathVariable int patientId, @RequestBody Patient patient){
        return patientService.updatePatientById(patientId, patient);
    }

    //Delete --> delete patient by id
    @DeleteMapping("/patient/{patientId}")
    private String deletePatientById(@PathVariable int patientId){
        return patientService.deletePatientById(patientId);
    }
}

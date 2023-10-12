package com.patient.app.service;

import com.patient.app.model.Patient;
import com.patient.app.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepo patientRepo;
    @Override
    public String insertNewPatient(Patient patient) {
        return patientRepo.insertNewPatient(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.getAllPatients();
    }

    @Override
    public Object getPatientById(int patientId) {
        return patientRepo.getPatientById(patientId);
    }

    @Override
    public String updatePatientById(int patientId, Patient patient) {
        return patientRepo.updatePatientById(patientId, patient);
    }

    @Override
    public String deletePatientById(int patientId) {
        return patientRepo.deletePatientById(patientId);
    }
}

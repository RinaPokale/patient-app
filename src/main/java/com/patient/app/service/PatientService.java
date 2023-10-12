package com.patient.app.service;

import com.patient.app.model.Patient;

import java.util.List;

public interface PatientService {
    String insertNewPatient(Patient patient);

    List<Patient> getAllPatients();

    Object getPatientById(int patientId);

    String updatePatientById(int patientId, Patient patient);

    String deletePatientById(int patientId);
}

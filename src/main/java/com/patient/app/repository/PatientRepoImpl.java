package com.patient.app.repository;

import com.patient.app.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PatientRepoImpl implements PatientRepo{
    private Map<Integer, Patient> patientMap = new HashMap<>();
    @Override
    public String insertNewPatient(Patient patient) {
        if(existPatient(patient)){
            return "Patient with id " + patient.getPatientId() + " already exist!";
        }
        patientMap.put(patient.getPatientId(), patient);
        return "Successfully inserted!";
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        for(int n: patientMap.keySet()){
            patients.add(patientMap.get(n));
        }
        return patients;
    }

    @Override
    public Object getPatientById(int patientId) throws RuntimeException{
        if(existPatient(patientId)){
            return patientMap.get(patientId);
        }
        throw new RuntimeException("Patient with id " + patientId + " doesn't exist!");
    }

    //Update --> patient by id
    @Override
    public String updatePatientById(int patientId, Patient patient) {
        if(existPatient(patientId)){
            patientMap.put(patientId, patient);
            return "Successfully Updated!";
        }
        return "Patient with id " + patientId + " doesn't exist!";
    }

    @Override
    public String deletePatientById(int patientId) {
        if(existPatient(patientId)){
            patientMap.remove(patientId);
            return "Deleted Successfully";
        }
        return "Patient with id " + patientId + " doesn't exist!";
    }

    //## Helper function
    private boolean existPatient(Patient patient){
       return existPatient(patient.getPatientId());
    }

    private boolean existPatient(int patientId){
        if(patientMap.containsKey(patientId))
            return true;
        else
            return false;
    }
}

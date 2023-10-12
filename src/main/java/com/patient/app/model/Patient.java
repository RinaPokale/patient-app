package com.patient.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String hospitalName;


}

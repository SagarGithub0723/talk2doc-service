package com.talk2doc.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetails {

    private long patientId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String gender;
    private int age;
    private String mobileNo;
    private String pw_pin;
    private int areaPinCode;

}

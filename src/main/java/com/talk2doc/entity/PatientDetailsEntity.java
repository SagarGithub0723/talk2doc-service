package com.talk2doc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PATIENT_DETAILS")
public class PatientDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    @Column(name = "mobile_no", unique = true)
    private String mobileNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "pw_pin", length = 6)
    private String pw_pin;

    @Column(name = "area_pin_code", length = 6)
    private int areaPinCode;

}

package com.talk2doc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor_details")
public class DoctorDetailsEntity {

    @Column(name = "doctor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorId;

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

    @Column(name = "pw_pin", length = 6)
    private String pw_pin;

    @Column(name = "area_pin_code", length = 6)
    private int areaPinCode;

    @Column(name = "specialist")
    private String specialist;

}

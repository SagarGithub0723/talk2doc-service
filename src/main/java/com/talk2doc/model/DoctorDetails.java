package com.talk2doc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDetails {

    private long doctorId;
    private String mobileNo;
    private String firstName;
    private String lastName;
    private String emailId;
    private String gender;
    private String pw_pin;
    private int areaPinCode;
    private String specialist;

}

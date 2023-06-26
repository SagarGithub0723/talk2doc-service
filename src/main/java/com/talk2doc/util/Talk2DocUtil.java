package com.talk2doc.util;

import com.talk2doc.constants.Talk2DocConstant;
import com.talk2doc.model.DoctorDetails;
import com.talk2doc.model.PatientDetails;
import com.talk2doc.model.UserLogin;

import java.util.StringJoiner;

public class Talk2DocUtil {

    public static String getFullName(String firstName, String lastName) {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(firstName);
        joiner.add(lastName);
        return joiner.toString();
    }

    public static UserLogin getUserLogin(Object user) {
        UserLogin userLogin = new UserLogin();
        if(user instanceof DoctorDetails) {
            DoctorDetails doctor = (DoctorDetails) user;
            userLogin.setUserName(getFullName(
                    doctor.getFirstName(), doctor.getLastName()
            ));
            userLogin.setMobileNo(doctor.getMobileNo());
            userLogin.setPw_pin(doctor.getPw_pin());
            userLogin.setDepartment(Talk2DocConstant.DOCTOR);
        }
        else if (user instanceof PatientDetails) {
            PatientDetails patient = (PatientDetails) user;
            userLogin.setUserName(getFullName(
                    patient.getFirstName(), patient.getLastName()
            ));
            userLogin.setMobileNo(patient.getMobileNo());
            userLogin.setPw_pin(patient.getPw_pin());
            userLogin.setDepartment(Talk2DocConstant.PATIENT);
        }
        return userLogin;
    }

}

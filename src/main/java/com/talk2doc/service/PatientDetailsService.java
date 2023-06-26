package com.talk2doc.service;

import com.talk2doc.model.PatientDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientDetailsService {
    PatientDetails addPatientDetails(PatientDetails patientDetails);

    List<PatientDetails> getAllPatientDetails();

    PatientDetails getPatientDetailsByMobileNo(String mobileNo);
}

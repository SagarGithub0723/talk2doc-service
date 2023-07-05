package com.talk2doc.service;

import com.talk2doc.model.PatientDetails;
import com.talk2doc.model.PatientQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientDetailsService {
    PatientDetails addPatientDetails(PatientDetails patientDetails);

    List<PatientDetails> getAllPatientDetails();

    PatientDetails getPatientDetailsByMobileNo(String mobileNo);

    PatientQuery savePatientQuery(PatientQuery patientQuery);
    List<PatientQuery> getAllQueries();

    List<PatientQuery> getAllQueriesByPatient(String mobileNo);

    PatientQuery getPatientQueryById(Long id);

    PatientQuery updatePatientQueryById(Long id, PatientQuery patientQuery);
}

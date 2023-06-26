package com.talk2doc.service;

import com.talk2doc.model.DoctorDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DoctorDetailsService {
    DoctorDetails addDoctorDetails(DoctorDetails doctorDetails);

    List<DoctorDetails> getAllDoctorDetails();

    DoctorDetails getDoctorDetailsByMobileNo(String mobileNo);
}

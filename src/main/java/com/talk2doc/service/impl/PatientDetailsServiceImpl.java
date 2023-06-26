package com.talk2doc.service.impl;

import com.talk2doc.entity.PatientDetailsEntity;
import com.talk2doc.model.PatientDetails;
import com.talk2doc.repository.PatientDetailsRepository;
import com.talk2doc.service.PatientDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

    private final PatientDetailsRepository patientDetailsRepository;

    public PatientDetailsServiceImpl(@Autowired PatientDetailsRepository patientDetailsRepository) {
        this.patientDetailsRepository = patientDetailsRepository;
    }

    @Override
    public PatientDetails addPatientDetails(PatientDetails patientDetails) {
        PatientDetailsEntity patientDetailsEntity = new PatientDetailsEntity();
        BeanUtils.copyProperties(patientDetails, patientDetailsEntity);
        patientDetailsRepository.save(patientDetailsEntity);
        return patientDetails;
    }

    @Override
    public List<PatientDetails> getAllPatientDetails() {
        List<PatientDetailsEntity> patientDetailsEntityList = patientDetailsRepository.findAll();
        List<PatientDetails> patientDetailsList = patientDetailsEntityList.stream().map(patientDetailsEntity -> new PatientDetails(
                patientDetailsEntity.getPatientId(),
                patientDetailsEntity.getFirstName(),
                patientDetailsEntity.getLastName(),
                patientDetailsEntity.getEmailId(),
                patientDetailsEntity.getGender(),
                patientDetailsEntity.getAge(),
                patientDetailsEntity.getMobileNo(),
                patientDetailsEntity.getPw_pin(),
                patientDetailsEntity.getAreaPinCode()
            )).collect(Collectors.toList());
        return patientDetailsList;
    }

    @Override
    public PatientDetails getPatientDetailsByMobileNo(String mobileNo) {
        System.out.println("mobileNo : " + mobileNo);
        PatientDetailsEntity entity = patientDetailsRepository.findByMobileNo(mobileNo);
        System.out.println("patientDetailsEntity: " + entity);
        PatientDetails patientDetails = new PatientDetails();
        if (entity != null)
            BeanUtils.copyProperties(entity, patientDetails);
        System.out.println("patientDetails: " + patientDetails);

        return patientDetails;
    }
}

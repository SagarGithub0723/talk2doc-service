package com.talk2doc.service.impl;

import com.talk2doc.entity.DoctorDetailsEntity;
import com.talk2doc.model.DoctorDetails;
import com.talk2doc.repository.DoctorDetailsRepository;
import com.talk2doc.service.DoctorDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

    private final DoctorDetailsRepository doctorDetailsRepository;

    public DoctorDetailsServiceImpl(@Autowired DoctorDetailsRepository doctorDetailsRepository) {
        this.doctorDetailsRepository = doctorDetailsRepository;
    }

    @Override
    public DoctorDetails addDoctorDetails(DoctorDetails doctorDetails) {
        DoctorDetailsEntity doctorDetailsEntity = new DoctorDetailsEntity();
        BeanUtils.copyProperties(doctorDetails, doctorDetailsEntity);
        doctorDetailsRepository.save(doctorDetailsEntity);
        return doctorDetails;
    }

    @Override
    public List<DoctorDetails> getAllDoctorDetails() {
        List<DoctorDetailsEntity> doctorDetailsEntityList = doctorDetailsRepository.findAll();
        List<DoctorDetails> doctorDetailsList = doctorDetailsEntityList.stream()
                .map(docEntity -> new DoctorDetails(
                docEntity.getDoctorId(),
                docEntity.getMobileNo(),
                docEntity.getFirstName(),
                docEntity.getLastName(),
                docEntity.getEmailId(),
                docEntity.getGender(),
                docEntity.getPw_pin(),
                docEntity.getAreaPinCode(),
                docEntity.getSpecialist()
                )).collect(Collectors.toList());
        return doctorDetailsList;
    }

    @Override
    public DoctorDetails getDoctorDetailsByMobileNo(String mobileNo) {
        DoctorDetailsEntity doctorDetailsEntity = doctorDetailsRepository.findByMobileNo(mobileNo);
        DoctorDetails doctorDetails = new DoctorDetails();
        if (doctorDetailsEntity != null)
            BeanUtils.copyProperties(doctorDetailsEntity, doctorDetails);
        return doctorDetails;
    }
}

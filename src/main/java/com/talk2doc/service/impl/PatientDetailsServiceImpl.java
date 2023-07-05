package com.talk2doc.service.impl;

import com.talk2doc.entity.PatientDetailsEntity;
import com.talk2doc.entity.PatientQueryEntity;
import com.talk2doc.model.PatientDetails;
import com.talk2doc.model.PatientQuery;
import com.talk2doc.repository.PatientDetailsRepository;
import com.talk2doc.repository.PatientQueryRepository;
import com.talk2doc.service.PatientDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

    private final PatientDetailsRepository patientDetailsRepository;

    private final PatientQueryRepository queryRepository;
    public PatientDetailsServiceImpl(@Autowired PatientDetailsRepository patientDetailsRepository,
                                     @Autowired PatientQueryRepository queryRepository) {
        this.patientDetailsRepository = patientDetailsRepository;
        this.queryRepository = queryRepository;
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

    @Override
    public PatientQuery savePatientQuery(PatientQuery patientQuery) {
        PatientQueryEntity queryEntity = new PatientQueryEntity();
        BeanUtils.copyProperties(patientQuery, queryEntity);
        queryRepository.save(queryEntity);
        return patientQuery;
    }

    @Override
    public List<PatientQuery> getAllQueries() {
        List<PatientQueryEntity> queryEntities = queryRepository.findAll();
        List<PatientQuery> queries = queryEntities.stream()
                .map(queryEntity -> new PatientQuery(
                        queryEntity.getId(),
                        queryEntity.getQueryDescription(),
                        queryEntity.getQueryRelatedWith(),
                        queryEntity.getMobileNo(),
                        queryEntity.getPatientName(),
                        queryEntity.getQueryStatus()
                )).collect(Collectors.toList());
        return queries;
    }

    @Override
    public List<PatientQuery> getAllQueriesByPatient(String mobileNo) {
        List<PatientQueryEntity> queryEntities = queryRepository.findByMobileNo(mobileNo);
        List<PatientQuery> queries = queryEntities.stream()
                .map(queryEntity -> new PatientQuery(
                        queryEntity.getId(),
                        queryEntity.getQueryDescription(),
                        queryEntity.getQueryRelatedWith(),
                        queryEntity.getMobileNo(),
                        queryEntity.getPatientName(),
                        queryEntity.getQueryStatus()
                )).collect(Collectors.toList());
        return queries;
    }

    @Override
    public PatientQuery getPatientQueryById(Long id) {
        PatientQuery query = new PatientQuery();
        PatientQueryEntity queryEntity = queryRepository.findById(id).get();
        BeanUtils.copyProperties(queryEntity, query);
        return query;
    }

    @Override
    public PatientQuery updatePatientQueryById(Long id, PatientQuery patientQuery) {
        PatientQueryEntity queryEntity = queryRepository.findById(id).get();
        queryEntity.setQueryDescription(patientQuery.getQueryDescription());
        queryEntity.setQueryRelatedWith(patientQuery.getQueryRelatedWith());
        queryRepository.save(queryEntity);
        return patientQuery;
    }
}

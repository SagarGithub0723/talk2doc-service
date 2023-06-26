package com.talk2doc.repository;

import com.talk2doc.entity.PatientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetailsEntity, Long> {
    PatientDetailsEntity findByMobileNo(String mobileNo);
}

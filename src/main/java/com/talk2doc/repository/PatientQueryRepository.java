package com.talk2doc.repository;

import com.talk2doc.entity.PatientQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientQueryRepository extends JpaRepository<PatientQueryEntity, Long> {
    List<PatientQueryEntity> findByMobileNo(String mobileNo);
}

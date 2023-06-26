package com.talk2doc.repository;

import com.talk2doc.entity.DoctorDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetailsEntity, Long> {

    DoctorDetailsEntity findByMobileNo(String mobileNo);
}

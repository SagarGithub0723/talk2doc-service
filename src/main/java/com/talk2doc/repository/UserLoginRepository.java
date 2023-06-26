package com.talk2doc.repository;

import com.talk2doc.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long> {
    UserLoginEntity findByMobileNo(String mobileNo);
}

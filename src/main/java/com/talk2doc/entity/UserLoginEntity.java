package com.talk2doc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_login")
public class UserLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "pw_pin")
    private String pw_pin;
    @Column(name = "department")
    private String department;

}

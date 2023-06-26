package com.talk2doc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

    private long id;
    private String userName;
    private String mobileNo;
    private String pw_pin;
    private String department;

}

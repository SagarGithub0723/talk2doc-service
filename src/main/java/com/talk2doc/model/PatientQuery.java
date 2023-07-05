package com.talk2doc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientQuery {

    private long id;

    private String queryDescription;

    private String queryRelatedWith;

    private String mobileNo;

    private String patientName;

    private String queryStatus;

}

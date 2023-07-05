package com.talk2doc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients_queries")
public class PatientQueryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "query_id")
    private long id;

    @Column(name = "query_desc")
    private String queryDescription;

    @Column(name = "query_related")
    private String queryRelatedWith;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "query_status")
    private String queryStatus;

}

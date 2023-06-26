package com.talk2doc.controller;

import com.talk2doc.exception.PatientException;
import com.talk2doc.model.PatientDetails;
import com.talk2doc.model.UserLogin;
import com.talk2doc.service.PatientDetailsService;
import com.talk2doc.service.UserLoginService;
import com.talk2doc.util.Talk2DocUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/talk2doc/")
public class PatientController {

    private final PatientDetailsService patientDetailsService;
    private final UserLoginService loginService;


    public PatientController(@Autowired PatientDetailsService patientDetailsService,
                             @Autowired UserLoginService loginService) {
        this.patientDetailsService = patientDetailsService;
        this.loginService = loginService;
    }

    @PostMapping("/patients")
    public ResponseEntity<String> addPatientDetails(@RequestBody PatientDetails patientDetails) throws PatientException {
        patientDetails = patientDetailsService.addPatientDetails(patientDetails);
        UserLogin login = Talk2DocUtil.getUserLogin(patientDetails);
        login = loginService.addUserLogin(login);
        System.out.println("Patient Login details added Successfully: " + login);
        return new ResponseEntity<>("Patient details added successfully", HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<Object> getAllPatientDetails() throws PatientException {
        List<PatientDetails> patientDetailsList = patientDetailsService.getAllPatientDetails();
        if(patientDetailsList.isEmpty())
            return new ResponseEntity<>("Patient Details not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(patientDetailsList, HttpStatus.OK);
    }


    @GetMapping("/patients/{mobileNo}")
    public ResponseEntity<Object> getPatientDetailsByMobileNo(@PathVariable String mobileNo) throws PatientException {
        PatientDetails patientDetails = patientDetailsService.getPatientDetailsByMobileNo(mobileNo);
        if(patientDetails == null)
            return new ResponseEntity<>("Patient not found for mobile no : " + mobileNo, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(patientDetails, HttpStatus.OK);

    }

}

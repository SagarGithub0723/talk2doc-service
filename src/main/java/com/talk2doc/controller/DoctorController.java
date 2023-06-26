package com.talk2doc.controller;

import com.talk2doc.exception.DoctorException;
import com.talk2doc.model.DoctorDetails;
import com.talk2doc.model.UserLogin;
import com.talk2doc.service.DoctorDetailsService;
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
public class DoctorController {

    private DoctorDetailsService doctorDetailsService;
    private UserLoginService loginService;

    public DoctorController(@Autowired DoctorDetailsService doctorDetailsService,
                            @Autowired UserLoginService loginService) {
        this.doctorDetailsService = doctorDetailsService;
        this.loginService = loginService;
    }

    @PostMapping("/doctors")
    public ResponseEntity<DoctorDetails> addDoctorDetails(@RequestBody DoctorDetails doctorDetails) {
        doctorDetails = doctorDetailsService.addDoctorDetails(doctorDetails);
        UserLogin login = Talk2DocUtil.getUserLogin(doctorDetails);
        login = loginService.addUserLogin(login);
        System.out.println("Doctor Login details added Successfully: " + login);
        return new ResponseEntity<>(doctorDetails, HttpStatus.OK);
    }


    @GetMapping("/doctors")
    public ResponseEntity<Object> getAllDoctorDetails() throws DoctorException {
        List<DoctorDetails> doctorDetailsList = doctorDetailsService.getAllDoctorDetails();
        if(doctorDetailsList.isEmpty())
            return new ResponseEntity<>("Doctors not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(doctorDetailsList, HttpStatus.OK);
    }

    @GetMapping("/doctors/{mobileNo}")
    public ResponseEntity<Object> getDoctorDetailsByMobileNo(@PathVariable String mobileNo) throws DoctorException {
        DoctorDetails doctorDetails = doctorDetailsService.getDoctorDetailsByMobileNo(mobileNo);
        if(doctorDetails == null)
            return new ResponseEntity<>("Doctor not found for mobile no : " + mobileNo, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(doctorDetails, HttpStatus.OK);
    }

}

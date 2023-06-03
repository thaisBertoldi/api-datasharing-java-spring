package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.repository.AppointmentRepository;
import com.abserver.datasharing.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

}

package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.repository.AppointmentRepository;
import com.abserver.datasharing.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

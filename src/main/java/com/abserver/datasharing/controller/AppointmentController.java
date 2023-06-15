package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.dto.AppointmentDTO;
import com.abserver.datasharing.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Appointment> create(@Valid @RequestBody AppointmentDTO dto){
        Appointment obj = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}

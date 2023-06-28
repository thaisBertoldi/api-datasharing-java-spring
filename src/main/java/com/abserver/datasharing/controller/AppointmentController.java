package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.dto.AppointmentDTO;
import com.abserver.datasharing.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

    @PutMapping(value = "status-cancel/{id}")
    public ResponseEntity<Appointment> updateStatusCanceled(@PathVariable Integer id){
        Appointment obj = service.updateStatusCanceled(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Appointment>> findPage(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "initialSchedule")String orderBy,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        return ResponseEntity.ok(service.findPage(page, linesPerPage, direction, orderBy));
    }

}

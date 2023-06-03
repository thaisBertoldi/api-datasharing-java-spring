package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.repository.AppointmentRepository;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment findById(Integer id) {
        Optional<Appointment> obj = appointmentRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found! ID: " + id + ", Type: " + Appointment.class.getName()));
    }

}

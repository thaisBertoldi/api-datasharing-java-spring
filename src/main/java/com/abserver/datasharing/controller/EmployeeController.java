package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Employee;
import com.abserver.datasharing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.findById(id));
    }
}

package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Employee;
import com.abserver.datasharing.repository.EmployeeRepository;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Integer id) {
        Optional<Employee> obj = employeeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found! ID: " + id + ", Type: " + Employee.class.getName()));
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        Employee newEmployee = new Employee(employee.getId(), employee.getName());
        return employeeRepository.save(newEmployee);
    }

}

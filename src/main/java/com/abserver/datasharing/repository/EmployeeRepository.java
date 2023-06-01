package com.abserver.datasharing.repository;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

package com.weg.employeeservice.repository;

import com.weg.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}

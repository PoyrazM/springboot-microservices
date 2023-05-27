package com.weg.employeeservice.service;

import com.weg.employeeservice.dto.APIResponseDto;
import com.weg.employeeservice.dto.EmployeeDto;
import com.weg.employeeservice.dto.EmployeeSaveRequest;
import java.util.List;

public interface IEmployeeService {

    EmployeeDto saveEmployee(EmployeeSaveRequest employeeSaveRequest);

    List<EmployeeDto> getAllEmployees();

    APIResponseDto getEmployeeById(Long id);

}

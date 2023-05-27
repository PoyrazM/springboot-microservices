package com.weg.employeeservice.controller;

import com.weg.employeeservice.dto.APIResponseDto;
import com.weg.employeeservice.dto.EmployeeDto;
import com.weg.employeeservice.dto.EmployeeSaveRequest;
import com.weg.employeeservice.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeSaveRequest employeeSaveRequest) {
        var savedEmployee = this.employeeService.saveEmployee(employeeSaveRequest);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        var employees = this.employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long employeeId) {
        var apiResponseDto = this.employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(apiResponseDto);
    }
}

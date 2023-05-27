package com.weg.departmentservice.controller;

import com.weg.departmentservice.dto.DepartmentDto;
import com.weg.departmentservice.dto.DepartmentSaveRequest;
import com.weg.departmentservice.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/departments")
public class DepartmentController {

    private final IDepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentSaveRequest departmentSaveRequest) {
        var savedDepartment = this.departmentService.saveDepartment(departmentSaveRequest);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode) {
        var department = this.departmentService.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(department);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        var departments = this.departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}

package com.weg.departmentservice.service;

import com.weg.departmentservice.dto.DepartmentDto;
import com.weg.departmentservice.dto.DepartmentSaveRequest;
import java.util.List;

public interface IDepartmentService {
    DepartmentDto saveDepartment(DepartmentSaveRequest departmentSaveRequest);

    DepartmentDto getDepartmentByCode(String code);

    List<DepartmentDto> getAllDepartments();
}

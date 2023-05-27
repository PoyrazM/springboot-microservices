package com.weg.departmentservice.service.impl;

import com.weg.departmentservice.dto.DepartmentDto;
import com.weg.departmentservice.dto.DepartmentSaveRequest;
import com.weg.departmentservice.entity.Department;
import com.weg.departmentservice.mapper.DepartmentMapper;
import com.weg.departmentservice.repository.IDepartmentRepository;
import com.weg.departmentservice.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {

    private final IDepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentSaveRequest departmentSaveRequest) {
        // Convert department dto to department jpa entity

        Department department = DepartmentMapper.MAP.departmentDtoToDepartment(departmentSaveRequest);

        department = departmentRepository.save(department);

        return DepartmentMapper.MAP.departmentToDepartmentDto(department);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.MAP.departmentToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return DepartmentMapper.MAP.departmentToDepartmentDtoList(departments);
    }
}

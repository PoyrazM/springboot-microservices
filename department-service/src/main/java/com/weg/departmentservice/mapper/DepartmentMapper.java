package com.weg.departmentservice.mapper;

import com.weg.departmentservice.dto.DepartmentDto;
import com.weg.departmentservice.dto.DepartmentSaveRequest;
import com.weg.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper MAP = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto departmentToDepartmentDto(Department department);

    List<DepartmentDto> departmentToDepartmentDtoList(List<Department> departmentList);

    Department departmentDtoToDepartment(DepartmentSaveRequest departmentSaveRequest);

}

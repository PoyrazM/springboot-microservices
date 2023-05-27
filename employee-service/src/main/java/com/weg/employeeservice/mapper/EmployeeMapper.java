package com.weg.employeeservice.mapper;

import com.weg.employeeservice.dto.EmployeeDto;
import com.weg.employeeservice.dto.EmployeeSaveRequest;
import com.weg.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAP = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> employeeList);

    Employee employeeDtoToEmployee(EmployeeSaveRequest employeeSaveRequest);
}


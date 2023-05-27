package com.weg.employeeservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;

}

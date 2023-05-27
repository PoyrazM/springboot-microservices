package com.weg.departmentservice.dto;

public record DepartmentDto(Long id,
                            String departmentName,
                            String departmentDescription,
                            String departmentCode) {
}

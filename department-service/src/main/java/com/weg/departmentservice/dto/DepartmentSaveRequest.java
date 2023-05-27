package com.weg.departmentservice.dto;

public record DepartmentSaveRequest(String departmentName,
                                    String departmentDescription,
                                    String departmentCode) {
}

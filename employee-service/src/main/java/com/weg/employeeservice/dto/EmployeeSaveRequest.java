package com.weg.employeeservice.dto;

public record EmployeeSaveRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String departmentCode) {
}

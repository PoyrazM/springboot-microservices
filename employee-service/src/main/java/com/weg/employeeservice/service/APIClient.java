package com.weg.employeeservice.service;

import com.weg.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(url = "http://localhost:4001;http://localhost:4008", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping(value = "api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);

}

package com.weg.employeeservice.service.impl;

import com.weg.employeeservice.config.WebClientConfig;
import com.weg.employeeservice.dto.APIResponseDto;
import com.weg.employeeservice.dto.DepartmentDto;
import com.weg.employeeservice.dto.EmployeeDto;
import com.weg.employeeservice.dto.EmployeeSaveRequest;
import com.weg.employeeservice.entity.Employee;
import com.weg.employeeservice.mapper.EmployeeMapper;
import com.weg.employeeservice.repository.IEmployeeRepository;
import com.weg.employeeservice.service.APIClient;
import com.weg.employeeservice.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    private final APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeSaveRequest employeeSaveRequest) {
        Employee employee = EmployeeMapper.MAP.employeeDtoToEmployee(employeeSaveRequest);

        employeeRepository.save(employee);

        return EmployeeMapper.MAP.employeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();

        return EmployeeMapper.MAP.employeeListToEmployeeDtoList(employees);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {

            EmployeeDto employeeDto = EmployeeMapper.MAP.employeeToEmployeeDto(employee.get());

//            ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:4001/api/departments/" + employee.get().getDepartmentCode(), DepartmentDto.class);
//
//            DepartmentDto departmentDto = responseEntity.getBody();

//            DepartmentDto departmentDto = webClient.get()
//                    .uri("http://localhost:4001/api/departments/" + employee.get().getDepartmentCode())
//                    .retrieve()
//                    .bodyToMono(DepartmentDto.class)
//                    .block();

            DepartmentDto departmentDto = apiClient.getDepartment(employeeDto.departmentCode());

            return APIResponseDto.builder()
                    .departmentDto(departmentDto)
                    .employeeDto(employeeDto)
                    .build();
        } else throw new RuntimeException("Employee is not found with id : " + id);
    }
}

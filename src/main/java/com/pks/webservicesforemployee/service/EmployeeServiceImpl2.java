package com.pks.webservicesforemployee.service;


import com.pks.webservicesforemployee.exception.EmployeeNotFoundException;
import com.pks.webservicesforemployee.models.Employee;
import com.pks.webservicesforemployee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl2 implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(@RequestBody Employee employee) {

        com.pks.webservicesforemployee.entity.Employee employee1 = new com.pks.webservicesforemployee.entity.Employee();
        BeanUtils.copyProperties(employee,employee1);
        employeeRepository.save(employee1);
        return employee;
    }


    @Override
    public List<Employee> getAllEmployeeMethod() {
        List<com.pks.webservicesforemployee.entity.Employee> entity
                = employeeRepository.findAll();
       List<Employee> employees = entity.stream()
               .map(e->{  Employee employee = new Employee();
                         BeanUtils.copyProperties(e,employee);
                         return employee;
                        }
        ).collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeMethod(Long employeeId) {

        com.pks.webservicesforemployee.entity.Employee employEntity
                = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EmployeeNotFoundException(
                        "Employee with id  "+ employeeId+ "not found"
                ));
        Employee employee = new Employee(
              employEntity.getEmployeeId(),
                employEntity.getLastName(),
                employEntity.getLastName(),
                employEntity.getEmailId(),
                employEntity.getDepartment()
        );
        return employee;
    }


    @Override
    public Employee deleteEmployeId(Long employeeId) {


        com.pks.webservicesforemployee.entity.Employee employEntity
                = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EmployeeNotFoundException(
                        "Employee with id  "+ employeeId+ "not found"
                ));
        employeeRepository.delete(employEntity);
        Employee employee = new Employee(
                employEntity.getEmployeeId(),
                employEntity.getLastName(),
                employEntity.getLastName(),
                employEntity.getEmailId(),
                employEntity.getDepartment()
        );
        return employee;
    }
}

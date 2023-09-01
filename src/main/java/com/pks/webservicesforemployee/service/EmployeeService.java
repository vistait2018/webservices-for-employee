package com.pks.webservicesforemployee.service;

import com.pks.webservicesforemployee.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

   List<Employee> getAllEmployeeMethod();

    Employee getEmployeeMethod(Long employeeId);

    Employee deleteEmployeId(Long employeeId);
}

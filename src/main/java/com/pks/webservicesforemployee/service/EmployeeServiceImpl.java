package com.pks.webservicesforemployee.service;

import com.pks.webservicesforemployee.exception.EmployeeNotFoundException;
import com.pks.webservicesforemployee.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static Long counter =1L;
   private List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getEmployeeId() == null
        || employee.getEmailId().isEmpty()){
            employee.setEmployeeId(counter);
        }
      employeeList.add(employee);
        counter += counter;
        return employee;
    }

    @Override
    public List<Employee> getAllEmployeeMethod() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeMethod(Long employeeId) {
        return employeeList.stream()
                .filter(e->e.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(()->new EmployeeNotFoundException("" +
                        "employee with id "+ employeeId+"" +
                        " could not be found" ));
    }

    @Override
    public Employee deleteEmployeId(Long employeeId) {
        Employee employeeToRemove = employeeList.stream()
                .filter(e-> e.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException("" +
                        "employee with id "+ employeeId+"" +
                        " could not be found" ));
        employeeList.remove(employeeToRemove);
        return employeeToRemove;
    }
}

package com.pks.webservicesforemployee.controllers;

import com.pks.webservicesforemployee.models.Employee;
import com.pks.webservicesforemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeControllerV1 {


    @Autowired
    @Qualifier("employeeServiceImpl")
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        Employee saveEmployee =employeeService.saveEmployee(employee);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
   @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployess(){
        return new ResponseEntity<>(employeeService.getAllEmployeeMethod(),HttpStatus.OK) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getAllEmployee(@PathVariable("id") Long employeeId){
        return new ResponseEntity<>(employeeService.getEmployeeMethod(employeeId),HttpStatus.OK) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployeId(@PathVariable("id") Long employeeId){
        return new ResponseEntity<>(employeeService.deleteEmployeId(employeeId),HttpStatus.OK) ;
    }
}

package com.pks.webservicesforemployee.repository;

import com.pks.webservicesforemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

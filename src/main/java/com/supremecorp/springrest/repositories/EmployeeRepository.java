package com.supremecorp.springrest.repositories;

import com.supremecorp.springrest.domains.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

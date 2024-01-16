package com.javatpoint.repository;

import com.javatpoint.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
}

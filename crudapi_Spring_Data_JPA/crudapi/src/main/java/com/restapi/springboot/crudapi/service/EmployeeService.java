package com.restapi.springboot.crudapi.service;

import com.restapi.springboot.crudapi.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId );

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);
}

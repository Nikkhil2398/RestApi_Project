package com.restapi.springboot.crudapi.rest;


import com.restapi.springboot.crudapi.Entity.Employee;

import com.restapi.springboot.crudapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theemployee= employeeService.findById(employeeId);

        if(theemployee == null){
            throw new RuntimeException("Employee not found :" +theemployee);
        }

        return theemployee;

    }
    @PostMapping("/employees/addemployee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.saveEmployee(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees/update/")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee= employeeService.saveEmployee(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found: " +employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id " +employeeId;
    }




}

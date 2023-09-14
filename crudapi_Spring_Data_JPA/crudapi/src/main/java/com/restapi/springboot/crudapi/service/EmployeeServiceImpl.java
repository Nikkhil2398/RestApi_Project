package com.restapi.springboot.crudapi.service;


import com.restapi.springboot.crudapi.Entity.Employee;
import com.restapi.springboot.crudapi.dao.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepositoy){
        employeeRepository=theEmployeeRepositoy;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
        }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee= null;

        if(result.isPresent()){
            theEmployee=result.get();

        }
        else{
            throw new RuntimeException("Employee id not found: "+theId);
        }

        return theEmployee;
    }


    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }


}

package com.bridgelabs.employeepayrollapp2.controller;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/employeeList")
/**
 *
 * @Author:PALLAVI JAGTAP
 * @since:8-12-21
 * @version:2.0.1
 */

public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/get-all-list")
     public List<EmployeePayrollDetails> getAllEmployee(){
        return employeePayrollService.getAllEmployee();
    }

    @PostMapping(value="/add-employee")
    public EmployeePayrollModel addEmployee(@RequestBody EmployeePayrollDetails employeeDto){
        return employeePayrollService.addEmploye(employeeDto);
    }
    @PutMapping( value ="/edit-name/{id}")
    public EmployeePayrollModel editId(@RequestBody EmployeePayrollDetails employeeDto, @PathVariable int id){
        return employeePayrollService.editId(employeeDto,id);
    }
    @DeleteMapping(value="/delete_name/{id}")
    public String deleteById(@PathVariable Integer id){
        return employeePayrollService.delete(id);
    }
    }



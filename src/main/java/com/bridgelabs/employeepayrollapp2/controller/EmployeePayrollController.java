package com.bridgelabs.employeepayrollapp2.controller;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @Author:PALLAVI JAGTAP
 * @since:8-12-21
 * @version:2.0.1
 */

@RestController
@RequestMapping(value = "/employeeList")

public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/get-all-list-of-employee")
    public List<EmployeePayrollDetails> getAllList() {
        return employeePayrollService.getAllListOfEmployeeDetails();

    }

    @PostMapping(value = "/Add-employee-details")
   public String addDetails(@Valid @RequestBody EmployeePayrollDetails employeePayrollDetails){
        return employeePayrollService.addDetails(employeePayrollDetails);
    }

    @PutMapping("/update-list/{id}")
    public String updateEmployeeDetail(@RequestBody EmployeePayrollDetails employeePayrollDetails, @PathVariable int id) {
        return employeePayrollService.updateEmployeeDetails(employeePayrollDetails, id);
    }
    @DeleteMapping("/delet/{id}")
    public String deleteEmployeeId(@PathVariable int id){
        return employeePayrollService.deleteEmployeeId(id);
    }


}

package com.bridgelabs.employeepayrollapp2.controller;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Purpose : To demonstrate different HTTP methods
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */
@RestController
@RequestMapping(value = "/employeeList")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;
    /**
     * Purpose :This API(Application programming Interface) is created for getting the list of the employee
     */
    @GetMapping(value = "/get-all-list-of-employee")
    public List<EmployeePayrollDetails> getAllList() {
        return employeePayrollService.getAllListOfEmployeeDetails();
    }

    /**
     * Purpose :This API(Application programming Interface) is created for registering new employee data into system
     * @param employeePayrollDetails : takes the details of employee using POJO class of employee by using @RequestBody
     */
    @PostMapping(value = "/Add-employee-details")
    public String addDetails(@RequestBody EmployeePayrollDetails employeePayrollDetails) {
        return employeePayrollService.addDetails(employeePayrollDetails);
    }

    /**
     * Purpose : This API(Application programming Interface) is created for update the employee details
     * according to their respective employee id
     * @param id : takes the employee id of corresponding employee
     * @param employeePayrollDetails : takes the details of employee using POJO class of employee by using @RequestBody
     */
    @PutMapping("/update-list/{id}")
    public String updateEmployeeDetail(@RequestBody EmployeePayrollDetails employeePayrollDetails, @PathVariable int id) {
        return employeePayrollService.updateEmployeeDetails(employeePayrollDetails, id);
    }

    /**
     * Purpose : This API(Application programming Interface) is created for deleting the employee details
     * according to their respective employee id
     * @param id :takes the employee id of corresponding employee
     */
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeId(@PathVariable int id) {
        return employeePayrollService.deleteEmployeeId(id);
    }
}

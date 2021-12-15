package com.bridgelabs.employeepayrollapp2.controller;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
/**************************************************************************************************************************
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 ***************************************************************************************************************************/


@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    EmployeePayrollDetails employeePayrollDetails;
    EmployeePayrollDetails employeePayrollDetails2;
    EmployeePayrollDetails employeePayrollDetails3;

    @InjectMocks
    private EmployeePayrollController employeePayrollController;
    @Mock
    private EmployeePayrollService employeePayrollService;

    @BeforeEach
    void setUp() {
       //() employeePayrollDetails = new EmployeePayrollDetails();
        employeePayrollDetails.setEmpDepartment("It");
        employeePayrollDetails.setEmpGender("female");
        employeePayrollDetails.setEid(2);
        employeePayrollDetails.setEmpImagePath("img1");
        employeePayrollDetails.setEmpNotes("java");
        employeePayrollDetails.setEmpSalary("20000");
        employeePayrollDetails.setEmpStartDate("12/12/12");
        employeePayrollDetails2 = new EmployeePayrollDetails();
        employeePayrollDetails2.setEmpDepartment("It");
        employeePayrollDetails2.setEmpGender("female");
        employeePayrollDetails2.setEid(3);
        employeePayrollDetails2.setEmpImagePath("img1");
        employeePayrollDetails2.setEmpNotes("java");
        employeePayrollDetails2.setEmpSalary("20000");
        employeePayrollDetails2.setEmpStartDate("12/12/12");

        employeePayrollDetails3 = new EmployeePayrollDetails();
        employeePayrollDetails3.setEmpDepartment("It");
        employeePayrollDetails3.setEmpGender("female");
        employeePayrollDetails3.setEid(3);
        employeePayrollDetails3.setEmpImagePath("img1");
        employeePayrollDetails3.setEmpNotes("java");
        employeePayrollDetails3.setEmpSalary("20000");
        employeePayrollDetails3.setEmpStartDate("12/12/12");

    }

    @Test
    void whenGetAllEmpCalled_shouldReturnListOfEmpDto() {
        when(employeePayrollController.getAllList()).thenReturn(List.of(employeePayrollDetails));
        Assertions.assertEquals(List.of(employeePayrollDetails), employeePayrollController.getAllList());
    }

    @Test
    void whenAddEmployeeDetailsCalled_shouldReturnGenerateSuccessMessage() {
        String successMessage = "added successfully";
        when(employeePayrollController.addDetails(employeePayrollDetails)).thenReturn(successMessage);
        String actualResponse = employeePayrollController.addDetails(employeePayrollDetails);
        Assertions.assertEquals(actualResponse, successMessage);
    }

    @Test
    void whenEmployeeIdDeleted_shouldReturnSuccessMessage() {
        String successMessage = "id deleted successfully";
        int id = 1;
        when(employeePayrollService.deleteEmployeeId(id)).thenReturn(successMessage);
        String actualResponse = employeePayrollController.deleteEmployeeId(id);
        Assertions.assertEquals(successMessage, actualResponse);
    }

    @Test
    void givenPayrollDto_whenCalledUpdatePayroll_shouldReturnSuccessMessage() {
        String successMessage = "updated successfully";
        int id = 2;
//        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
//        employeePayrollDetails.setEmpDepartment("It");
//        employeePayrollDetails.setEmpGender("female");
//        employeePayrollDetails.setEid(3);
//        employeePayrollDetails.setEmpImagePath("img1");
//        employeePayrollDetails.setEmpNotes("java");
//        employeePayrollDetails.setEmpSalary("20000");
//        employeePayrollDetails.setEmpStartDate("12/12/12");
        when(employeePayrollService.updateEmployeeDetails(employeePayrollDetails, id)).thenReturn("updated successfully");
        String actualResponse = employeePayrollController.updateEmployeeDetail(employeePayrollDetails, id);
        Assertions.assertEquals(successMessage, actualResponse);
    }

}


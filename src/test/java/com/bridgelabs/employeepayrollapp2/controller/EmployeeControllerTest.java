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

/**
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    EmployeePayrollDetails employeePayrollDetails;

    @InjectMocks
    private EmployeePayrollController employeePayrollController;
    @Mock
    private EmployeePayrollService employeePayrollService;

    @BeforeEach
    void setUp() {
        employeePayrollDetails = new EmployeePayrollDetails();
        employeePayrollDetails.setEmpDepartment(List.of("It", "hr", "manager"));
        employeePayrollDetails.setEmpGender("female");
        employeePayrollDetails.setEmpImagePath("img1");
        employeePayrollDetails.setEmpNotes("java");
        employeePayrollDetails.setEmpSalary("20000");
        employeePayrollDetails.setEmpStartDate("12/12/12");
    }

    @Test
    void whenGetAllEmpCalled_shouldReturnListOfEmpDto() {
        when(employeePayrollController.getAllList()).thenReturn(List.of(employeePayrollDetails));
        Assertions.assertEquals(List.of(employeePayrollDetails), employeePayrollController.getAllList());
    }

    @Test
    void whenAddEmployeeDetailsCalled_shouldReturnGenerateSuccessMessage() { String successMessage = "added successfully";
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
        when(employeePayrollService.updateEmployeeDetails(employeePayrollDetails, id)).thenReturn("updated successfully");
        String actualResponse = employeePayrollController.updateEmployeeDetail(employeePayrollDetails, id);
        Assertions.assertEquals(successMessage, actualResponse);
    }
}


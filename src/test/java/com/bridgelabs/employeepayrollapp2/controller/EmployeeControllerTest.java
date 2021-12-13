package com.bridgelabs.employeepayrollapp2.controller;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeePayrollController employeePayrollController;
    @Mock
    private EmployeePayrollService employeePayrollService;

//    @BeforeEach
//     void listOfOllEmployeeDetails() {
//       EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
//       employeePayrollDetails.setEmpDepartment("It");
//       employeePayrollDetails.setEmpGender("female");
//       employeePayrollDetails.setEid(2);
//       employeePayrollDetails.setEmpImagePath("img1");
//       employeePayrollDetails.setEmpNotes("java");
//       employeePayrollDetails.setEmpSalary("20000");
//       employeePayrollDetails.setEmpStartDate("12/12/12");
//       EmployeePayrollDetails employeePayrollDetails2 = new EmployeePayrollDetails();
//       employeePayrollDetails2.setEmpDepartment("It");
//       employeePayrollDetails2.setEmpGender("female");
//        employeePayrollDetails2.setEid(3);
//        employeePayrollDetails2.setEmpImagePath("img1");
//        employeePayrollDetails2.setEmpNotes("java");
//        employeePayrollDetails2.setEmpSalary("20000");
//        employeePayrollDetails2.setEmpStartDate("12/12/12");
//        EmployeePayrollDetails employeePayrollDetails3 = new EmployeePayrollDetails();
//        employeePayrollDetails3.setEmpDepartment("It");
//        employeePayrollDetails3.setEmpGender("female");
//        employeePayrollDetails3.setEid(3);
//        employeePayrollDetails3.setEmpImagePath("img1");
//        employeePayrollDetails3.setEmpNotes("java");
//        employeePayrollDetails3.setEmpSalary("20000");
//        employeePayrollDetails3.setEmpStartDate("12/12/12");

   // }

    @Test
    void whenGetAllEmpCalled_shouldReturnListOfEmpDto() {
        List<EmployeePayrollDetails>employeePayrollDetailsList;
        EmployeePayrollDetails employeePayrollDetails1 = new EmployeePayrollDetails();
        employeePayrollDetails1.setEmpDepartment("It");
        employeePayrollDetails1.setEmpGender("female");
        employeePayrollDetails1.setEid(2);
        employeePayrollDetails1.setEmpImagePath("img1");
        employeePayrollDetails1.setEmpNotes("java");
        employeePayrollDetails1.setEmpSalary("20000");
        employeePayrollDetails1.setEmpStartDate("12/12/12");
       EmployeePayrollDetails employeePayrollDetails2 = new EmployeePayrollDetails();
        employeePayrollDetails2.setEmpDepartment("It");
       employeePayrollDetails2.setEmpGender("female");
        employeePayrollDetails2.setEid(3);
        employeePayrollDetails2.setEmpImagePath("img1");
        employeePayrollDetails2.setEmpNotes("java");
        employeePayrollDetails2.setEmpSalary("20000");
        employeePayrollDetails2.setEmpStartDate("12/12/12");
        employeePayrollDetailsList = List.of(employeePayrollDetails2,employeePayrollDetails1);
        when(employeePayrollService.getAllListOfEmployeeDetails()).thenReturn(employeePayrollDetailsList);
        List<EmployeePayrollDetails>actualResponse = employeePayrollController.getAllList();
        for(int i = 0; i <actualResponse.size();i++){
            assertEquals(employeePayrollDetailsList.get(i).getEid(), actualResponse.get(i).getEid());
            assertEquals(employeePayrollDetailsList.get(i).getEmpName(), actualResponse.get(i).getEmpName());
            assertEquals(employeePayrollDetailsList.get(i).getEmpGender(), actualResponse.get(i).getEmpGender());
            assertEquals(employeePayrollDetailsList.get(i).getEmpDepartment(), actualResponse.get(i).getEmpDepartment());
            assertEquals(employeePayrollDetailsList.get(i).getEmpSalary(), actualResponse.get(i).getEmpSalary());
        }
    }
}

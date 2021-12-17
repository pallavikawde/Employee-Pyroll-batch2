package com.bridgelabs.employeepayrollapp2.integration;

import com.bridgelabs.employeepayrollapp2.controller.EmployeePayrollController;
import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**************************************************************************************************************************
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 ***************************************************************************************************************************/


@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeePayrollController.class)
public class EmployeeControllerIt {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeePayrollService employeePayrollService;

    EmployeePayrollDetails employeePayrollDetails;
    EmployeePayrollDetails employeePayrollDetails2;
    EmployeePayrollDetails employeePayrollDetails3;


    @BeforeEach
    void setUp() {
        employeePayrollDetails = new EmployeePayrollDetails();
        employeePayrollDetails.setEmpDepartment(List.of("IT","HR","MANAGER"));
        employeePayrollDetails.setEmpGender("female");
        employeePayrollDetails.setEmpImagePath("img1");
        employeePayrollDetails.setEmpNotes("java");
        employeePayrollDetails.setEmpSalary("20000");
        employeePayrollDetails.setEmpStartDate("12/12/12");
//        employeePayrollDetails2 = new EmployeePayrollDetails();
//        employeePayrollDetails2.setEmpDepartment("It");
//        employeePayrollDetails2.setEmpGender("female");
//        employeePayrollDetails2.setEmpImagePath("img1");
//        employeePayrollDetails2.setEmpNotes("java");
//        employeePayrollDetails2.setEmpSalary("20000");
//        employeePayrollDetails2.setEmpStartDate("12/12/12");
//
//        employeePayrollDetails3 = new EmployeePayrollDetails();
//        employeePayrollDetails3.setEmpDepartment("It");
//        employeePayrollDetails3.setEmpGender("female");
//        employeePayrollDetails3.setEmpImagePath("img1");
//        employeePayrollDetails3.setEmpNotes("java");
//        employeePayrollDetails3.setEmpSalary("20000");
//        employeePayrollDetails3.setEmpStartDate("12/12/12");

    }

    @Test
    void getAllEmployeeDetailsTest() throws Exception {
        // when(employeePayrollService.getAllListOfEmployeeDetails()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employeeList/get-all-list-of-employee"))
                .andExpect(status().isOk());
    }

    @Test
    void addEmployeDetailsTest() throws Exception {
        String dto = objectMapper.writeValueAsString(employeePayrollDetails);
        //when(employeePayrollService.addDetails(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/employeeList/Add-employee-details")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void updateEmployeeDetailsTest() throws Exception {
        String dto = objectMapper.writeValueAsString(employeePayrollDetails);
        //when(employeePayrollService.addDetails(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                .put("/employeeList/update-list/2")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();


    }
    @Test
    void deleteEmployeeDetailsTest() throws Exception {
        String dto = objectMapper.writeValueAsString(employeePayrollDetails);
        //when(employeePayrollService.addDetails(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/employeeList/delete/4")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();


    }

}
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeePayrollController.class)
public class EmployeeControllerIt {

    ObjectMapper objectMapper = new ObjectMapper();
    EmployeePayrollDetails employeePayrollDetails;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeePayrollService employeePayrollService;

    @BeforeEach
    void setUp() {
        employeePayrollDetails = new EmployeePayrollDetails();
        employeePayrollDetails.setEmpDepartment(List.of("IT", "HR", "MANAGER"));
        employeePayrollDetails.setEmpGender("female");
        employeePayrollDetails.setEmpImagePath("img1");
        employeePayrollDetails.setEmpNotes("java");
        employeePayrollDetails.setEmpSalary("20000");
        employeePayrollDetails.setEmpStartDate("12/12/12");
    }

    @Test
    void getAllEmployeeDetailsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employeeList/get-all-list-of-employee"))
                .andExpect(status().isOk());
    }

    @Test
    void addEmployeDetailsTest() throws Exception {
        String dto = objectMapper.writeValueAsString(employeePayrollDetails);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/employeeList/Add-employee-details")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void updateEmployeeDetailsTest() throws Exception {
        String dto = objectMapper.writeValueAsString(employeePayrollDetails);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/employeeList/update-list/2")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void deleteEmployeeDetailsTest() throws Exception {
        String dto = objectMapper.writeValueAsString(employeePayrollDetails);
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/employeeList/delete/4")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
    }
}
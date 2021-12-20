package com.bridgelabs.employeepayrollapp2.service;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.repo.EmployeePayrollRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeePayrollService employeePayrollService;
    @Mock
    private EmployeePayrollRepository employeePayrollRepository;
    @Mock
    private ModelMapper mapper;

    EmployeePayrollDetails employeePayrollDetails;
    EmployeePayrollDetails employeePayrollDetails2;
    EmployeePayrollModel employeePayrollModel;
    EmployeePayrollModel employeePayrollModel1;

    @BeforeEach
    void setUp() {
        employeePayrollDetails = new EmployeePayrollDetails();
        employeePayrollDetails.setEmpDepartment(List.of("HR","MANAGER","IT"));
        employeePayrollDetails.setEmpGender("female");
        employeePayrollDetails.setEmpImagePath("img1");
        employeePayrollDetails.setEmpNotes("java");
        employeePayrollDetails.setEmpSalary("20000");
        employeePayrollDetails.setEmpStartDate("12/12/12");
        employeePayrollDetails2 = new EmployeePayrollDetails();
        employeePayrollDetails2.setEmpDepartment(List.of("HR","MANAGER","IT"));
        employeePayrollDetails2.setEmpGender("female");
        employeePayrollDetails2.setEmpImagePath("img1");
        employeePayrollDetails2.setEmpNotes("java");
        employeePayrollDetails2.setEmpSalary("20000");
        employeePayrollDetails2.setEmpStartDate("12/12/12");
        employeePayrollModel = new EmployeePayrollModel();
        employeePayrollModel.setEmpDepartment(List.of("HR"));
        employeePayrollModel.setEmpGender("female");
        employeePayrollModel.setEmpImagePath("img1");
        employeePayrollModel.setEmpNotes("java");
        employeePayrollModel.setEmpSalary("20000");
        employeePayrollModel.setEmpStartDate("12/12/12");
        employeePayrollModel1 = new EmployeePayrollModel();
        employeePayrollModel1.setEmpDepartment(List.of("HR"));
        employeePayrollModel1.setEmpGender("female");
        employeePayrollModel1.setEmpImagePath("img1");
        employeePayrollModel1.setEmpNotes("java");
        employeePayrollModel1.setEmpSalary("20000");
        employeePayrollModel1.setEmpStartDate("12/12/12");
    }

    @Test
    void whenGetAllEmpCalled_shouldReturnListOfEmpDto() {
        when(employeePayrollRepository.findAll()).thenReturn(List.of(employeePayrollModel));
        assertEquals(List.of(employeePayrollModel),employeePayrollRepository.findAll());
    }

    @Test
    void whenAddEmployeeDetailsCalled_shouldReturnGenerateSuccessMessage() {
        String successMessage = "DETAILS_ADDED_SUCCESSFULLY";
       when(mapper.map(employeePayrollDetails2,EmployeePayrollModel.class)).thenReturn(employeePayrollModel);
        String actualMessage = employeePayrollService.addDetails(employeePayrollDetails2);
        assertEquals(successMessage,actualMessage);
    }

    @Test
    void whenEmployeeIdDeleted_shouldReturnSuccessMessage() {
        String successMessage = "id deleted successfully";
        int id = 1;
        when(employeePayrollRepository.findById(id)).thenReturn(Optional.of(employeePayrollModel));
        String actualMessage = employeePayrollService.deleteEmployeeId(id);
        assertEquals(successMessage, actualMessage);
    }

    @Test
    void whenEmployeeIdUpdated_shouldReturnSuccessMessage() {
        String successMessage = "id updated successfully";
        int id = 2;
        when(employeePayrollRepository.findById(id)).thenReturn(Optional.of(employeePayrollModel));
        when(mapper.map(employeePayrollDetails,EmployeePayrollModel.class)).thenReturn(employeePayrollModel);
        String actualMessage = employeePayrollService.updateEmployeeDetails(employeePayrollDetails,id);
        assertEquals(successMessage, actualMessage);
    }
}




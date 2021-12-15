package com.bridgelabs.employeepayrollapp2.service;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.repo.EmployeePayrollRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import com.bridgelabs.employeepayrollapp2.repo.EmployeePayrollRepository;
import com.bridgelabs.employeepayrollapp2.service.EmployeePayrollService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

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

        employeePayrollModel.setEmpDepartment("It");
        employeePayrollModel.setEmpGender("female");
        employeePayrollModel.setEid(2);
        employeePayrollModel.setEmpImagePath("img1");
        employeePayrollModel.setEmpNotes("java");
        employeePayrollModel.setEmpSalary("20000");
        employeePayrollModel.setEmpStartDate("12/12/12");

        employeePayrollModel1.setEmpDepartment("It");
        employeePayrollModel1.setEmpGender("female");
        employeePayrollModel1.setEid(3);
        employeePayrollModel1.setEmpImagePath("img1");
        employeePayrollModel1.setEmpNotes("java");
        employeePayrollModel1.setEmpSalary("20000");
        employeePayrollModel1.setEmpStartDate("12/12/12");


    }

    @Test
    void whenGetAllEmpCalled_shouldReturnListOfEmpDto() {
        when(employeePayrollRepository.findAll()).thenReturn(List.of(employeePayrollModel));
        when(mapper.map(employeePayrollModel, EmployeePayrollDetails.class)).thenReturn(employeePayrollDetails);
        when(mapper.map(employeePayrollModel1, EmployeePayrollDetails.class)).thenReturn(employeePayrollDetails2);
        String ActualResponse = employeePayrollRepository.findAll().toString();
        Assertions.assertEquals(List.of(employeePayrollDetails), employeePayrollRepository.findAll());
    }
}

//    @Test
//    void whenAddEmployeeDetailsCalled_shouldReturnGenerateSuccessMessage() {
//        when(employeePayrollRepository.save()).thenReturn(List.of(employeePayrollModel));
//        when(mapper.map(employeePayrollModel,EmployeePayrollDetails.class)).thenReturn(employeePayrollDetails);
//        when(mapper.map(employeePayrollModel1,EmployeePayrollDetails.class)).thenReturn(employeePayrollDetails2);
//        String ActualResponse = employeePayrollRepository.findAll().toString();
//        Assertions.assertEquals(List.of(employeePayrollDetails), employeePayrollRepository.getAllList());
//    }
//
//    @Test
//    void whenEmployeeIdDeleted_shouldReturnSuccessMessage() {
//        String successMessage = "id deleted successfully";
//        int id = 1;
//        when(employeePayrollService.deleteEmployeeId(id)).thenReturn(successMessage);
//        String actualResponse = employeePayrollController.deleteEmployeeId(id);
//        Assertions.assertEquals(successMessage, actualResponse);
//    }
//
//    @Test
//    void givenPayrollDto_whenCalledUpdatePayroll_shouldReturnSuccessMessage() {
//        String successMessage = "updated successfully";
//        int id = 2;
////        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
////        employeePayrollDetails.setEmpDepartment("It");
////        employeePayrollDetails.setEmpGender("female");
////        employeePayrollDetails.setEid(3);
////        employeePayrollDetails.setEmpImagePath("img1");
////        employeePayrollDetails.setEmpNotes("java");
////        employeePayrollDetails.setEmpSalary("20000");
////        employeePayrollDetails.setEmpStartDate("12/12/12");
//        when(employeePayrollService.updateEmployeeDetails(employeePayrollDetails, id)).thenReturn("updated successfully");
//        String actualResponse = employeePayrollController.updateEmployeeDetail(employeePayrollDetails, id);
//        Assertions.assertEquals(successMessage, actualResponse);
//    }
//
//}
//
//    }
//}

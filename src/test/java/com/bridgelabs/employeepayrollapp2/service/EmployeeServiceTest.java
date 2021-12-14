//package com.bridgelabs.employeepayrollapp2.service;
//
//import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
//import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
//import com.bridgelabs.employeepayrollapp2.repo.EmployeePayrollRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeeServiceTest {
//    @InjectMocks
//   private EmployeePayrollService employeePayrollService;
//    @Mock
//   private EmployeePayrollRepository employeePayrollRepository;
//    @Mock
//    private ModelMapper mapper;
//
//    @Test
//    void given2payrollDtoInRepo_whenCalledGetAllPayroll_shouldReturnListOfPayrollDto(){
//        List<EmployeePayrollDetails>employeePayrollDetailsList = new ArrayList<>();
//        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
//        employeePayrollDetails.setEmpDepartment("It");
//        employeePayrollDetails.setEmpGender("female");
//         employeePayrollDetails.setEid(3);
//        employeePayrollDetails.setEmpImagePath("img1");
//        employeePayrollDetails.setEmpNotes("java");
//        employeePayrollDetails.setEmpSalary("20000");
//        employeePayrollDetails.setEmpStartDate("12/12/12");
//        employeePayrollDetailsList.add(employeePayrollDetails);
//
//        EmployeePayrollDetails employeePayrollDetails1= new EmployeePayrollDetails();
//        employeePayrollDetails1.setEmpDepartment("It");
//        employeePayrollDetails1.setEmpGender("female");
//        employeePayrollDetails1.setEid(4);
//        employeePayrollDetails1.setEmpImagePath("img1");
//        employeePayrollDetails1.setEmpNotes("java");
//        employeePayrollDetails1.setEmpSalary("20000");
//        employeePayrollDetails1.setEmpStartDate("12/12/12");
//        employeePayrollDetailsList.add(employeePayrollDetails1);
//
//        List<EmployeePayrollModel>employeePayrollModelList =new ArrayList<>();
//        EmployeePayrollModel employeePayrollModel = new EmployeePayrollModel();
//        employeePayrollModel.setEmpDepartment("It");
//        employeePayrollModel.setEmpGender("female");
//        employeePayrollModel.setEid(3);
//        employeePayrollModel.setEmpImagePath("img1");
//        employeePayrollModel.setEmpNotes("java");
//        employeePayrollModel.setEmpSalary("20000");
//        employeePayrollModel.setEmpStartDate("12/12/12");
//        EmployeePayrollModel employeePayrollModel2 = new EmployeePayrollModel();
//        employeePayrollModel2.setEmpDepartment("It");
//        employeePayrollModel2.setEmpGender("female");
//        employeePayrollModel2.setEid(3);
//        employeePayrollModel2.setEmpImagePath("img1");
//        employeePayrollModel2.setEmpNotes("java");
//        employeePayrollModel2.setEmpSalary("20000");
//        employeePayrollModel2.setEmpStartDate("12/12/12");
//        when(employeePayrollRepository.findAll()).thenReturn(employeePayrollModelList);
//        when(mapper.map(employeePayrollModelList.get(0),EmployeePayrollDetails.class)).thenReturn(employeePayrollDetails);
//        when(mapper.map(employeePayrollModelList.get(1),EmployeePayrollDetails.class)).thenReturn(employeePayrollDetails1);
//        List<EmployeePayrollDetails>actualResponse =  employeePayrollService.getAllListOfEmployeeDetails();
//        Assertions.assertEquals(2,actualResponse.size());
//        Assertions.assertEquals(employeePayrollDetailsList,actualResponse);
//    }
//
//    @Test
//    void givenPayrollDto_whenCalledAddPayroll_shouldReturnSuccessMessage() {
//        String successMessage = "DETAILS_ADDED_SUCCESSFULLY";
//        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
//        employeePayrollDetails.setEmpDepartment("It");
//        employeePayrollDetails.setEmpGender("female");
//        employeePayrollDetails.setEid(3);
//        employeePayrollDetails.setEmpImagePath("img1");
//        employeePayrollDetails.setEmpNotes("java");
//        employeePayrollDetails.setEmpSalary("20000");
//        employeePayrollDetails.setEmpStartDate("12/12/12");
//
//        EmployeePayrollModel employeePayrollModel = new EmployeePayrollModel();
//        employeePayrollModel.setEmpDepartment("It");
//        employeePayrollModel.setEmpGender("female");
//        employeePayrollModel.setEid(3);
//        employeePayrollModel.setEmpImagePath("img1");
//        employeePayrollModel.setEmpNotes("java");
//        employeePayrollModel.setEmpSalary("20000");
//        employeePayrollModel.setEmpStartDate("12/12/12");
//        when(mapper.map(employeePayrollDetails,EmployeePayrollModel.class)).thenReturn(employeePayrollModel);
//        String actualMessage = employeePayrollService.addDetails(employeePayrollDetails);
//        Assertions.assertEquals(successMessage,actualMessage);
////        varify(employeePayrollRepository,times(1)).save(employeePayrollModel);
//
//    }
//
//    @Test
//    void givenIdAndPayrollDto_whenCalledUpdatePayroll_shouldReturnSuccessMessage(){
//       int id = 1;
//       String acceptedMessage = "id updated successfully";
//        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
//        employeePayrollDetails.setEmpDepartment("It");
//        employeePayrollDetails.setEmpGender("female");
//        employeePayrollDetails.setEid(3);
//        employeePayrollDetails.setEmpImagePath("img1");
//        employeePayrollDetails.setEmpNotes("java");
//        employeePayrollDetails.setEmpSalary("20000");
//        employeePayrollDetails.setEmpStartDate("12/12/12");
//
//        EmployeePayrollModel employeePayrollModel = new EmployeePayrollModel();
//        employeePayrollModel.setEmpDepartment("It");
//        employeePayrollModel.setEmpGender("female");
//        employeePayrollModel.setEid(3);
//        employeePayrollModel.setEmpImagePath("img1");
//        employeePayrollModel.setEmpNotes("java");
//        employeePayrollModel.setEmpSalary("20000");
//        employeePayrollModel.setEmpStartDate("12/12/12");
//    //    when(employeePayrollRepository.);
//    }
//
//    @Test
//    void  givenId_whenCalledDeletePayroll_shouldReturnSuccessMessage() {
//        String successMessage = "id deleted successfully";
//        int id = 1;
//        EmployeePayrollDetails employeePayrollDetails = new EmployeePayrollDetails();
//        employeePayrollDetails.setEmpDepartment("It");
//        employeePayrollDetails.setEmpGender("female");
//        employeePayrollDetails.setEid(3);
//        employeePayrollDetails.setEmpImagePath("img1");
//        employeePayrollDetails.setEmpNotes("java");
//        employeePayrollDetails.setEmpSalary("20000");
//        employeePayrollDetails.setEmpStartDate("12/12/12");
//
//        EmployeePayrollModel employeePayrollModel = new EmployeePayrollModel();
//        employeePayrollModel.setEmpDepartment("It");
//        employeePayrollModel.setEmpGender("female");
//        employeePayrollModel.setEid(3);
//        employeePayrollModel.setEmpImagePath("img1");
//        employeePayrollModel.setEmpNotes("java");
//        employeePayrollModel.setEmpSalary("20000");
//        employeePayrollModel.setEmpStartDate("12/12/12");
//        when(employeePayrollRepository.deleteById(id)).thenReturn(successMessage);
//        String actualMessage = employeePayrollService.deleteEmployeeId(id);
//        Assertions.assertEquals(successMessage,actualMessage);
//    }
//}

package com.bridgelabs.employeepayrollapp2.service;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.exception.EmptyInputException;
import com.bridgelabs.employeepayrollapp2.repo.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@Service
public class EmployeePayrollService {

    private static final String DETAILS_ADDED_SUCCESSFULLY = "DETAILS_ADDED_SUCCESSFULLY ";
    private static final String UPDATED_SUCCESSFULLY = "id updated successfully";
    private static final String ID_DELETED_SUCCESSFULLY = "id deleted successfully";

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Autowired
    private ModelMapper mapper;

    public List<EmployeePayrollDetails> getAllListOfEmployeeDetails() {
        return employeePayrollRepository.findAll().stream().map(employeePayrollModel1 ->mapper.map(employeePayrollModel1,EmployeePayrollDetails.class)).collect(Collectors.toList());
    }

    public String addDetails(EmployeePayrollDetails employeePayrollDetails) {
        if(employeePayrollDetails.getEmpName().isEmpty()||employeePayrollDetails.getEmpName().length()==0){
        throw new EmptyInputException("601","please check");
        }
        EmployeePayrollModel employeePayrollModel =mapper.map(employeePayrollDetails,EmployeePayrollModel.class);
        employeePayrollRepository.save(employeePayrollModel);
        return DETAILS_ADDED_SUCCESSFULLY;
    }

    public String updateEmployeeDetails(EmployeePayrollDetails employeePayrollDetails, int id) {
        EmployeePayrollModel employeePayrollModel = checkIdPresentOrNot(id);
        mapper.map(employeePayrollDetails,employeePayrollModel);
        employeePayrollRepository.save(employeePayrollModel);
        return UPDATED_SUCCESSFULLY;
    }
    public EmployeePayrollModel checkIdPresentOrNot(int id){
        return employeePayrollRepository.findById(id).get();
    }

    public String deleteEmployeeId(int id) {
        employeePayrollRepository.deleteById(id);
        return ID_DELETED_SUCCESSFULLY;
    }


}




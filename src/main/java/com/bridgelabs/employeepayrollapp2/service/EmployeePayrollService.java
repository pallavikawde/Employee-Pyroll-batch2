package com.bridgelabs.employeepayrollapp2.service;

import com.bridgelabs.employeepayrollapp2.dto.EmployeePayrollDetails;
import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import com.bridgelabs.employeepayrollapp2.repo.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@Service
public class EmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeePayrollModel addEmploye(EmployeePayrollDetails employeDto) {
        EmployeePayrollModel employeePayrollModel= modelMapper.map(employeDto, EmployeePayrollModel.class);
        return employeePayrollRepository.save(employeePayrollModel);

    }

    public EmployeePayrollModel editId(EmployeePayrollDetails employeeDto,Integer id) {
        Optional<EmployeePayrollModel> employeePayrollEntityById = employeePayrollRepository.findById(id);
        if (employeePayrollEntityById.isPresent()) {
            EmployeePayrollModel employeePayrollModel =  employeePayrollEntityById.get();
            modelMapper.map(employeeDto,EmployeePayrollModel.class);
            employeePayrollRepository.save(employeePayrollModel);
        }
        return null;

    }

    public String delete(Integer id) {
        Optional<EmployeePayrollModel> employeePayrollEntityById = employeePayrollRepository.findById(id);
        if (employeePayrollEntityById.isPresent()) {
            employeePayrollRepository.delete(employeePayrollEntityById.get());
            return "id deleted sucessfully";
        }else
        return "record not exists";

    }

    public List<EmployeePayrollDetails> getAllEmployee() {
        return employeePayrollRepository
                .findAll()
                .stream()
                .map(employeePayrollModel1 -> modelMapper.map(employeePayrollModel1,EmployeePayrollDetails.class))
                .collect(Collectors.toList());

        }
    }


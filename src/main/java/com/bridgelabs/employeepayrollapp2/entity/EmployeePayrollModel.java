package com.bridgelabs.employeepayrollapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @Author:PALLAVI JAGTAP
 * @since:8-12-21
 * @version:2.0.1
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollModel {
    @Max(value=10)
    private int id;
    private String name;
    private double salary;
    private String department;
    @Past
    private LocalDate JoiningDate;

}

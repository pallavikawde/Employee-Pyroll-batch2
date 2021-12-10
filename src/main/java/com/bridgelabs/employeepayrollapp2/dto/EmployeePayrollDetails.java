package com.bridgelabs.employeepayrollapp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @Author:PALLAVI JAGTAP
 * @since:8-12-21
 * @version:2.0.1
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDetails {
    private String name;
    private double salary;
    private String department;
    @Past
    private LocalDate StartingDate;
}

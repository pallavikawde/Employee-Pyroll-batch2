package com.bridgelabs.employeepayrollapp2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

/****************************************************************************************************************************
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 ****************************************************************************************************************************/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDetails {
        private int eid;
    @NotNull
    @Pattern(regexp = "^[A-Za-z ]{3,28}$", message = "The name can not contain any numbers or symbols.")
    private String empName;

    @NotNull
    @Pattern(regexp = "[A-Z]", message = "The gender should be one character in length")
    private String empGender;

    @NotNull
    @Pattern(regexp = "[A-Z]{3}")
    private String empDepartment;

    @NotNull
    @Pattern(regexp = "[0-9]{4,7}")
    @Pattern(regexp = "^[0-9]{4,7}$", message = "Salary can not contain any alphabets and can not be larger than 7 digits")
    private String empSalary;

    @NotNull
    @Past
    @Pattern(regexp = "[0-9/-]{9,11}")
    private String empStartDate;

    @NotNull
    private String empNotes;

    @NotNull
    private String empImagePath;

}


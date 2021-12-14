package com.bridgelabs.employeepayrollapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*****************************************************************************************************************************
 *
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 **************************************************************************************************************************/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll")
public class EmployeePayrollModel {
    @Id
    @Column(name = "eid")
    private int eid;
    @Column(name = "empName")
    private String empName;
    @Column(name = "empGender")
    private String empGender;
    @Column(name = "empDepartment")
    private String empDepartment;
    @Column(name = "empSalary")
    private String empSalary;
    @Column(name = "empStartDate")
    private String empStartDate;
    @Column(name = "empNotes")
    private String empNotes;
    @Column(name = "empImagePath")
    private String empImagePath;
}


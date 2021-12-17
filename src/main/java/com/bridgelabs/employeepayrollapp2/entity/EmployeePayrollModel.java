package com.bridgelabs.employeepayrollapp2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Purpose : to contain the entities in ths db
 *
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll")
public class EmployeePayrollModel {
    @Id
    @GeneratedValue
    @Column(name = "eid")
    private int eid;
    @Column(name = "empName")
    private String empName;
    @Column(name = "empGender")
    private String empGender;
   @ElementCollection
   @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name="id"))
    @Column(name = "empDepartment")
    private List<String> empDepartment;


    @Column(name = "empSalary")
    private String empSalary;
    @Column(name = "empStartDate")
    private String empStartDate;
    @Column(name = "empNotes")
    private String empNotes;
    @Column(name = "empImagePath")
    private String empImagePath;
}


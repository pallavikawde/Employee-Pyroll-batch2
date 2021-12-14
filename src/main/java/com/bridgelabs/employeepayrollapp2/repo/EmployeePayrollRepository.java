package com.bridgelabs.employeepayrollapp2.repo;

import com.bridgelabs.employeepayrollapp2.entity.EmployeePayrollModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**************************************************************************************************************************
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 ***************************************************************************************************************************/

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollModel,Integer> {

}

package com.bank.dao;/*
 *
 * @project - SpringProject
 * @author - Babu Gumpu , on 14/05/2019
 *
 */

import com.bank.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    List<Employee> getEmployeeByID(String empNo);

    List<Employee> getEmployeeByIDandLastName(@Param("empNo") String empNo, @Param("empLastName") String empLastName);

    int addEmployee(@Param("empNo") Long empNo, @Param("birthDate") Date birthDate, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("gender") String gender, @Param("hireDate") Date hireDate);
}

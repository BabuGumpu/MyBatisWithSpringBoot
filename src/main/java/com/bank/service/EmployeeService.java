package com.bank.service;/*
 *
 * @project - mybatiswithspringboot
 * @author - Babu Gumpu , on 30/05/2019
 *
 */

import com.bank.dao.EmployeeDAO;
import com.bank.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeDAO employeeDAO;

    /**
     * @return
     */
    public List<Employee> getAllEmployees() {
        logger.info("::getAllEmployees Started -->");
        return employeeDAO.getAllEmployees();

    }

    /**
     * @param empNo
     * @return
     */
    public List<Employee> getEmployeeByID(String empNo) {
        logger.info("::getEmployeeByID Started -->");
        return employeeDAO.getEmployeeByID(empNo);
    }


    /**
     * @param empNo
     * @param empLastName
     * @return
     */
    public List<Employee> getEmployeeByIDandLastName(String empNo, String empLastName) {
        logger.info("::getEmployeeByIDandLastName empNo -->{} -->{}", empNo, empLastName);
        return employeeDAO.getEmployeeByIDandLastName(empNo, empLastName);
    }


    /**
     * @param empNo
     * @param birthDate
     * @param firstName
     * @param lastName
     * @param gender
     * @param hireDate
     */
    public int addEmpRecord(Long empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
        return employeeDAO.addEmployee(empNo, birthDate, firstName, lastName, gender, hireDate);
    }
}

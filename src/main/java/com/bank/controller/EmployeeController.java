package com.bank.controller;/*
 *
 * @project - SpringProject
 * @author - Babu Gumpu , on 14/05/2019
 *
 */

import com.bank.model.Employee;
import com.bank.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Employee> getAllEmployees() {
        //http://localhost:8080/api/test
        logger.info("::getAllEmployees  Started -->");
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/test")
    @ResponseBody
    public String getTest() {
        //http://localhost:8080/api/test
        logger.info("::getTest  Tesdting Started -->");
        return "Testing";
    }

    @GetMapping(path = "/getempbyid")
    @ResponseBody
    public Iterable<Employee> getEmployeeByID(@RequestParam String id) {
        //http://localhost:8080/api/getempbyid?id=10002
        logger.info("::getEmployeeByID  Testing Started -->{}", id);
        return employeeService.getEmployeeByID(id);

    }

    @RequestMapping(path = "/getEmpByIDandName")
    @ResponseBody
    public Iterable<Employee> getEmployeeByIDandLastName(@RequestParam(value = "empNo",required = true) String empNo, @RequestParam(value = "empLastName",required = true) String empLastName) {
        //http://localhost:8080/api/getEmpByIDandName?empNo=18106&lastName=Axelband
        logger.info("::getEmployeeByIDandLastName empNo -->{}   empLastName -->{}", empNo, empLastName);
        return employeeService.getEmployeeByIDandLastName(empNo, empLastName);

    }
}

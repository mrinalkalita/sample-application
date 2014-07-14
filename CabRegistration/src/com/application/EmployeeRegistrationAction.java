package com.application;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.example.bean.Employee;
import com.example.ejb.EmployeeDataEntryEJB;


public class EmployeeRegistrationAction {
    Logger log = Logger.getLogger(EmployeeRegistrationAction.class);
    Employee employee = null;
    
    public EmployeeRegistrationAction() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String execute() {
        log.debug("Inside EmployeeRegistration.execute");
        //Employee employee = new Employee();
        EmployeeDataEntryEJB employeeDataEntryEJB = null;

        try {
            employeeDataEntryEJB = (EmployeeDataEntryEJB) new InitialContext()
                .lookup("ejblocal:CabRegistrationEAR/EmployeeEJB.jar/EmployeeDataEntryEJB#com.example.ejb.EmployeeDataEntryEJB");
        } catch (NamingException ne) {
            System.out.println("Java Naming Exception");
            ne.printStackTrace();
        }


        if (employeeDataEntryEJB == null) {
            return "ERROR";
        }

        log.debug(employee);
        if (employee.getId() != null && !employee.getId().equals("")) {
            employeeDataEntryEJB.saveEmployeeData(employee);
        }

        return "SUCCESS";

    }

}

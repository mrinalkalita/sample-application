package com.application;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.example.bean.Employee;
import com.example.ejb.EmployeeDataViewerEJB;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeDataViewerAction extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Logger log = Logger.getLogger(EmployeeRegistrationAction.class);
    Employee employee = null;
    List<Employee> list = new ArrayList<Employee>();

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public EmployeeDataViewerAction() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String execute() {
        log.debug("Inside EmployeeDataViewer.execute");
        
        EmployeeDataViewerEJB employeeDataViewer = null;

        try {
            employeeDataViewer = (EmployeeDataViewerEJB) new InitialContext()
                .lookup("ejblocal:CabRegistrationEAR/EmployeeEJB.jar/EmployeeDataViewerEJB#com.example.ejb.EmployeeDataViewerEJB");
        } catch (NamingException ne) {
            System.out.println("Java Naming Exception");
        }

        if (employeeDataViewer == null) {
            return "ERROR";
        }
        System.out.println(employee);
        
        if (employee.isShowAll()) {
            list = employeeDataViewer.getEmployees();
        } else {
            list = employeeDataViewer.viewEmployeeData(employee);
        }

        for (Employee emp : list) {
            System.out.println(emp);
        }

        return "SUCCESS";

    }

}

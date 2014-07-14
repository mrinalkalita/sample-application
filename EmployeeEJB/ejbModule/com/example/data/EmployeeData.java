package com.example.data;

import com.example.bean.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class EmployeeData {
    public BasicDBObject toDBObject(Employee employee) {
        BasicDBObject doc = new BasicDBObject();
        if (employee.getId() != null && !employee.getId().trim().equals("")) {
            doc.put("id", employee.getId());
        }

        if (employee.getPassword() != null && !employee.getPassword().trim().equals("")) {
            doc.put("password", employee.getPassword());
        }

        if (employee.getName() != null && !employee.getName().trim().equals("")) {
            doc.put("name", employee.getName());
        }

        if (employee.getHomeAddress() != null && !employee.getHomeAddress().trim().equals("")) {
            doc.put("homeAddress", employee.getHomeAddress());
        }

        if (employee.getContactNumber() != null && !employee.getContactNumber().trim().equals("")) {
            doc.put("contactNumber", employee.getContactNumber());
        }

        if (employee.getOfficeAddress() != null && !employee.getOfficeAddress().trim().equals("")) {
            doc.put("officeAddress", employee.getOfficeAddress());
        }

        return doc;
    }

    public static Employee fromDBObject(DBObject doc) {
        Employee m = new Employee();

        m.setId((String) doc.get("id"));
        m.setName((String) doc.get("name"));
        m.setHomeAddress((String) doc.get("homeAddress"));
        m.setContactNumber((String) doc.get("contactNumber"));
        m.setOfficeAddress((String) doc.get("officeAddress"));

        return m;
    }

}

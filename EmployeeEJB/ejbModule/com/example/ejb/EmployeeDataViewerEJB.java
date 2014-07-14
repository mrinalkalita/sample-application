package com.example.ejb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import com.example.bean.Employee;
import com.example.data.EmployeeData;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;

/**
 * Session Bean implementation class EmployeeDataViewerEJB
 */
@Stateful
@LocalBean
public class EmployeeDataViewerEJB {

    DBCollection employeeColl;

    /**
     * Default constructor. 
     */
    public EmployeeDataViewerEJB() {
        // TODO Auto-generated constructor stub
    }

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    @PostConstruct
    private void initDB() {
        Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(10);
        builder.description("View");
        MongoClientOptions opt = builder.build();
        System.out.println(opt.getConnectionsPerHost());

        System.out.println("After Ejb creation!");
        Mongo m;
        try {
            m = new MongoClient("127.0.0.1:27017", opt);
            DB db = m.getDB("mydb");
            employeeColl = db.getCollection("employeeColl");
            if (employeeColl == null) {
                employeeColl = db.createCollection("employeeColl", null);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        DBCursor cur = employeeColl.find();
        System.out.println("getEmployees: Found " + cur.size() + " employee(s)");
        for (DBObject dbo : cur.toArray()) {
            employees.add(EmployeeData.fromDBObject(dbo));
        }

        return employees;
    }

    public List<Employee> viewEmployeeData(Employee employee) {
        System.out.println("In View Employee Data!");
        EmployeeData empData = new EmployeeData();
        List<Employee> employees = new ArrayList<Employee>();
        DBCursor cur = employeeColl.find(empData.toDBObject(employee));
        System.out.println(employee);
        for (DBObject dbo : cur.toArray()) {
            employees.add(EmployeeData.fromDBObject(dbo));
            System.out.println(EmployeeData.fromDBObject(dbo));
        }

        return employees;
    }

/*    public List<Employee> viewEmployeeData(Employee employee) {

        counter++;

        File file = new File("employee_data");
        List<Employee> returnList = new ArrayList<Employee>();
        
        BufferedReader in = null;
        
        try {

            in = new BufferedReader(new FileReader(file));
            String line;
            String name;

            
            while ((line = in.readLine()) != null) {
                String[] data = line.split(";");
                
                name = data[0];
                
                if (name.equals(employee.getName())) {
                    returnList.add(new Employee.EmployeeBuilder(data[0], data[1]).repeatPassword(data[2]).name(data[3])
                        .homeAddress(data[4]).contactNumber(data[5]).officeAddress(data[6]).createEmployee());
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        
        return returnList;

    }
*/

    @PreDestroy
    public void testPreDestroy() {
        System.out.println("Before Ejb destroy!");
    }

    @PrePassivate
    public void testPrePassivate() {
        System.out.println("Before Passivate!");
    }

    @PostActivate
    public void testPostActivate() {
        System.out.println("After Activate!");
    }

}

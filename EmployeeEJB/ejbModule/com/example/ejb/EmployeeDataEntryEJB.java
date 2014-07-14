package com.example.ejb;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.example.bean.Employee;
import com.example.data.EmployeeData;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Session Bean implementation class EmployeeDataEntryEJB
 */
@Stateless
@LocalBean
public class EmployeeDataEntryEJB {

    DBCollection employeeColl;

//    private Logger logger = Logger.getLogger(EmployeeDataEntryEJB.class);
    /**
     * Default constructor. 
     */
    public EmployeeDataEntryEJB() {
        // TODO Auto-generated constructor stub
    }

    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    @PostConstruct
    private void initDB() {
        System.out.println("After Ejb creation!");

        Mongo m;
        try {
            m = new MongoClient("127.0.0.1:27017");
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

    public void saveEmployeeData(Employee employee) {
        counter++;
        EmployeeData empData = new EmployeeData();
        BasicDBObject doc = empData.toDBObject(employee);
        employeeColl.insert(doc);

        System.out.println(employee);

        //logger.debug("Inside save emp");

        /*File file = new File("employee_data");
        BufferedWriter out = null;
        System.out.println(file.getAbsolutePath());

        validateInput(employee);

        try {

            boolean fileCreated = file.createNewFile();

            System.out.println("File created: " + fileCreated);

            out = new BufferedWriter(new FileWriter(file, true));
            out.write(employee + "\n");
            System.out.println("After write");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        */
    }

    /*private void validateInput(Employee employee) {
        
      //Validate input name and department
        if ((employee.getName() == null && employee.getName().trim().equals(""))
                || (employee.getContactNumber() == null && employee.getContactNumber().trim().equals(""))) {
            throw new IllegalArgumentException();
        }
    }
    */


    @PreDestroy
    private void testPreDestroy() {
        System.out.println("Before Ejb destroy!");
    }

        

}

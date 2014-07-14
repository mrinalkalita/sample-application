/**
 * @author Abinash
 * Bean class to hold employee information.
 */
package com.example.bean;


/**
 * 
 */
public class Employee {

    private String id;
    private String password;
    private String repeatPassword;
    private String name;
    private String homeAddress;
    private String contactNumber;
    private String officeAddress;
    
    private boolean showAll = false;

    public Employee() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public boolean isShowAll() {
        return showAll;
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    public Employee(String id, String password, String repeatPassword, String name, String homeAddress, String contactNumber,
            String officeAddress) {
        super();
        this.id = id;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
        this.homeAddress = homeAddress;
        this.contactNumber = contactNumber;
        this.officeAddress = officeAddress;
    }

    /**
     * {@inheritDoc}
     * This overridden toString will generate employee data in following format.
     * Name =<NAME>;email =<EMAIL>;Department =<DEPARTMENT>
     */
    public String toString() {
        return "Name =" + this.getName() + ";" + "Id =" + this.getId() + ";" + "Home Address =" + this.getHomeAddress() + ";"
                + "Contact Number =" + this.getContactNumber() + ";" + "Office Address =" + this.getOfficeAddress();
    }
    
    public static class EmployeeBuilder {
        private String volvoId;
        private String password;
        private String repeatPassword;
        private String name;
        private String homeAddress;
        private String contactNumber;
        private String officeAddress;

        public EmployeeBuilder() {

        }

        public EmployeeBuilder(String volvoId, String password) {
            this.volvoId = volvoId;
            this.password = password;
        }

        public EmployeeBuilder volvoId(final String volvoId) {
            this.volvoId = volvoId;
            return this;
        }

        public EmployeeBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public EmployeeBuilder repeatPassword(final String repeatPassword) {
            this.repeatPassword = repeatPassword;
            return this;
        }

        public EmployeeBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder homeAddress(final String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public EmployeeBuilder contactNumber(final String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public EmployeeBuilder officeAddress(final String officeAddress) {
            this.officeAddress = officeAddress;
            return this;
        }

        public Employee createEmployee() {
            return new Employee(volvoId, password, repeatPassword, name, homeAddress, contactNumber,
                officeAddress);
        }


    }

}

package com.shashank;

import jakarta.persistence.*;

import java.util.List;

// if we not use @Embeddable then hibernate cannot determine jdbc type of laptop
// Using embeddable it will merge the fields of employee and laptop and create a table
// note - still all those annotations of entity is valid like @Column
//@Embeddable
@Entity
public class Laptop {
    @Id
    int lID;
//    @Column(name="laptop_model")
    String model;
    // Since it can accommodate thus will not create new table
    @ManyToOne
    private Employee employee;
//    @ManyToMany(mappedBy = "laptops")
//    private List<Employee> employees;

    public int getlID() {
        return lID;
    }

    public void setlID(int lID) {
        this.lID = lID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lID=" + lID +
                ", model='" + model + '\'' +
                '}';
    }
}

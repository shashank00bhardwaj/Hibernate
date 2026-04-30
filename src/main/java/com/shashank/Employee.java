package com.shashank;

import jakarta.persistence.*;

// note entity comes from JPA. There are no of ORM tool and each tool works differently so JPA
// has set up certain standard which needs to be followed by everyone
// Usually the class name serves as entity name, entity name as table name
// if we need to change table name we can change entity name or table name directly
// also use hbm2ddl.auto as create instead of update
//@Entity(name = "Emp")
@Entity
//@Table(name="Emp")
public class Employee {
    @Id
    private int eID;
//    @Column(name = "employee_name")
    private String eName;
    //@Transient // this column will not be a part of table
    private int eAge;

    private Laptop laptop;

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int geteAge() {
        return eAge;
    }

    public void seteAge(int eAge) {
        this.eAge = eAge;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eID=" + eID +
                ", eName='" + eName + '\'' +
                ", eAge=" + eAge +
                ", laptop=" + laptop +
                '}';
    }
}

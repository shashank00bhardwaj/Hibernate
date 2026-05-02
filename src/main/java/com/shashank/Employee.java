package com.shashank;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

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
//    @OneToOne
//    private Laptop laptop;
    // for one employee multiple laptops
    // Since it's one to many from employee side and it cann't keep lid in it thus it will create new table, to avoid it use mappedBy=""
//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "employee")
//    @ManyToMany
    private List<Laptop> laptops;

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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "eID=" + eID +
                ", eName='" + eName + '\'' +
                ", eAge=" + eAge +
                ", laptop=" + laptops +
                '}';
    }
}

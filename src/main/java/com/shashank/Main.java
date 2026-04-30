package com.shashank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[]args){
        Laptop l1 = new Laptop();
        l1.setlID(1);
        l1.setModel("ASUS-ROG");

        Employee e1 = new Employee();
        e1.seteID(101); e1.seteName("Shashank Bhardwaj"); e1.seteAge(25); e1.setLaptop(l1);

        // In configuration, we specify database, username, password, db
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.shashank.Employee.class);
        cfg.configure();

        // create once per database
        SessionFactory factory = cfg.buildSessionFactory();
        // create new session for each unit of new work
        Session session = factory.openSession();
        // session.save is deprecated and removed

        // 1) SAVE DATA

        //creating transaction
        Transaction tx = session.beginTransaction();
        session.persist(e1);
        //committing transaction
        tx.commit();

        // 2) FETCH DATA - for fetching data we don't need to crate transaction and commit it later
        // note - get() is deprecated
        //System.out.println("Fetched Employee - " + session.find(Employee.class,1));

        // 3) UPDATE - first create objet you wish to update. Also, we need transaction. It works like save or update
//        session.merge(e1);
//        tx.commit();

        // 4) DELETE
//        session.remove(e1);
//        tx.commit();
        //closing resources
        session.close();
        factory.close();
        System.out.println(e1);
    }
}

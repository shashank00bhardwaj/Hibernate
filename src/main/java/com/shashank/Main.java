package com.shashank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[]args){
    /*
        Laptop l1 = new Laptop();
        l1.setlID(1);
        l1.setModel("ASUS-ROG");


        Laptop l2 = new Laptop();
        l2.setlID(2);
        l2.setModel("DELL-VOSTRO");

        Laptop l3 = new Laptop();
        l3.setlID(3);
        l3.setModel("Apple-AIR");

        Employee e1 = new Employee();
        e1.seteID(101); e1.seteName("Shashank Bhardwaj"); e1.seteAge(25);

        Employee e2 = new Employee();
        e2.seteID(102); e2.seteName("Krishna Soni"); e2.seteAge(24);
//
//        Employee e3 = new Employee();
//        e3.seteID(103); e3.seteName("Raghav Garg"); e3.seteAge(23);

        e1.setLaptops(Arrays.asList(l1,l2));
        e2.setLaptops(Arrays.asList(l3));
//        e3.setLaptops(Arrays.asList(l2));

        l1.setEmployee(e1);
        l2.setEmployee(e1);
        l3.setEmployee(e2);
//        l3.setEmployees(Arrays.asList(e2));

        // In configuration, we specify database, username, password, db
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.shashank.Employee.class);
        cfg.addAnnotatedClass(com.shashank.Laptop.class);
        cfg.configure();

        // create once per database
        SessionFactory factory = cfg.buildSessionFactory();
        // create new session for each unit of new work
        Session session = factory.openSession();
        // session.save is deprecated and removed

        // 1) SAVE DATA

        //creating transaction
        Transaction tx = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(e1);
        session.persist(e2);
//        session.persist(e3);
        //committing transaction
        tx.commit();
        session.close();
        // 2) FETCH DATA - for fetching data we don't need to crate transaction and commit it later
        // note - get() is deprecated
        // Note - we have created multiple sessions because in the same session it will read from 1 level cache
        // there are 2 levels of cache. If you want if it needs to read from cache not from db when we have 2 sessions then we need L2 cache which we need to configure using external applications
        // else it will read from db
        Session session1 = factory.openSession();
        // if only find is called without intention to use data like not printing it or initializing variable using it for later operations then
        // select query only from employee table will be called not from laptop table which it should have done ideally -- lazy fetching -- to
        // override we need to use fetch fetchtype eager in mapping annotation in employee
        session1.find(Employee.class,101);
//        System.out.println("Fetched Employee - " + session1.find(Employee.class,101)); // early fetching
        session1.close();
        // 3) UPDATE - first create objet you wish to update. Also, we need transaction. It works like save or update
//        session.merge(e1);
//        tx.commit();

        // 4) DELETE
//        session.remove(e1);
//        tx.commit();
        //closing resources
//        session.close();
        factory.close();
*/


        //HQL
        Student s1 = new Student();
        s1.setsId(1); s1.setsName("Shashank Bhardwaj"); s1.setsMarks(87);
        Student s2 = new Student();
        s2.setsId(2); s2.setsName("Raghav Garg"); s2.setsMarks(85);
        Student s3 = new Student();
        s3.setsId(3); s3.setsName("Krishna Soni"); s3.setsMarks(45);

        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.shashank.Student.class)
                            .configure()
                            .buildSessionFactory();

        Session session2  = sf.openSession();
//        Transaction tx = session2.beginTransaction();
//        session2.persist(s1);
//        session2.persist(s2);
//        session2.persist(s3);
//        tx.commit();

        Query hq1 = session2.createQuery("from Student where sMarks>50",Student.class);
        List<Student>scoredGreaterThan50 =  hq1.getResultList();
        System.out.println(scoredGreaterThan50);

        String req_name = "S%"; int req_marks = 50;
        Query<Object[]> hq2 = session2.createQuery("Select sName,sMarks from Student where sName like ?1 and sMarks > ?2",Object[].class);
        hq2.setParameter(1,req_name); hq2.setParameter(2,req_marks);
        List<Object[]>result = hq2.getResultList();
        for(Object[] eachRow : result){
            System.out.println("Student Name - "+ eachRow[0] + " Student Marks - "+ eachRow[1]);
        }
        session2.close();
        sf.close();
        /*
        * EAGER VS LAZY LOADING
        * get() VS load()
        * get() - will run query in all cases
        * load() - will only run query if data is used.
        *
        * For level 2 cache we can use ehCache
        * there is a standard for all level 2 cache which is jCache
        * So we need to add two dependencies in pom.xml one is of ehCache and the other is of jCache
        * Then we need to add @cachable over our entity
        * */
    }
}

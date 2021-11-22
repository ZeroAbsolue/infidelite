package com.Modele;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {
    private static Session session;
    private SessionFactory sessionFactory;

    public Database() {
        if (session == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
        } 
    }

    public void save(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public Session getSession() {
        return session;
    }

    public void commit(){
        session.getTransaction().commit();
    }

}

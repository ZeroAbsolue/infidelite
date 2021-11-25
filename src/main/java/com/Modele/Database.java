package com.Modele;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

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
        if (!session.getTransaction().getStatus().isOneOf(TransactionStatus.ACTIVE))
            session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    public Session getSession() {
        return session;
    }

    public void commit() {
        session.getTransaction().commit();
    }

}

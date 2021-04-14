package com.imadelfetouh.profileservice.dal.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class SessionWriteConfiguration {

    private final SessionFactory sessionFactory;

    public SessionWriteConfiguration() {
        Configuration configuration = ReadWriteConfiguration.getInstance().getConfiguration();
        configuration.getProperties().put(Environment.URL, "jdbc:mysql://"+System.getenv("PROFILESERVICE_MYSQL_MASTER_HOST")+":"+System.getenv("PROFILESERVICE_MYSQL_MASTER_PORT")+"/profileservice?createDatabaseIfNotExist=true");

        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}

package com.roganov.init;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerInit {

    public EntityManager initialize(){
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();

        return factory.createEntityManager();
    }

}

package com.alevel.moboperator;

import com.alevel.moboperator.entity.Account;
import com.alevel.moboperator.entity.Tariff;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class GetCallsLog {
    private static final Logger log = LoggerFactory.getLogger(GetCallsLog.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            EntityManager entityManager = sessionFactory.createEntityManager();
            //session.beginTransaction();

            Account source = new Account();
            //source.setPhoneNumber();

            Account target = new Account();
           // target.setPhoneNumber();

            //session.getTransaction().commit();

        }catch (Exception e) {
            log.error("Error while populating db with example data", e);
            //session.getTransaction().rollback();
        }
    }
}

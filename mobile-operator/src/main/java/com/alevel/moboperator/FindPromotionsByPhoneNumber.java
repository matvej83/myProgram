package com.alevel.moboperator;

import com.alevel.moboperator.entity.Account;
import com.alevel.moboperator.entity.Promotion;
import com.alevel.moboperator.util.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.graph.RootGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class FindPromotionsByPhoneNumber {
    private static final Logger log = LoggerFactory.getLogger(FindPromotionsByAccountId.class);

    public static void main(String[] args) {

        String phoneNumber = "";

        SessionFactory sessionFactory = HibernateHelper.createSessionFactory();
        Session session = sessionFactory.openSession();

        try(sessionFactory; session) {

            RootGraph<?> entityGraph = session.getEntityGraph("account-with-promotions");

            Account account = session.find(
                    Account.class,
                    1L,
                    Map.of("javax.persistence.fetchgraph", entityGraph)
            );

            if (account == null) {
                log.error("No account found for phone number {}", phoneNumber);
                return;
            }

            for (Promotion promotion : account.getTariff().getPromotions()) {
                log.info("Promotion '{}': {}", promotion.getName(), promotion.getDescription());
            }

        }

    }
}

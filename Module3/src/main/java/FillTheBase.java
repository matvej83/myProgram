import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Scanner;


public class FillTheBase {

    private static final Logger log = LoggerFactory.getLogger(JpaEntityManager.class);

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();

        try (sessionFactory;
             Scanner sc = new Scanner(System.in)
        ) {

            entityManager.getTransaction().begin();

            log.info("Creating initial data");
            System.out.println("Enter the first user name: ");
            String firstUserName = sc.next();
            User firstUser = new User();
            firstUser.setName(firstUserName);
            entityManager.persist(firstUser);
            log.info("User {} is created", firstUser.getName());
            System.out.println("Enter the second user name: ");
            String secondUserName = sc.next();
            User secondUser = new User();
            secondUser.setName(secondUserName);
            entityManager.persist(secondUser);
            log.info("User {} is created", secondUserName);
            secondUser.addPhotos("My holiday");
            entityManager.persist(secondUser);
            log.info("User {} added {} photos in his profile", secondUser.getName(), secondUser.getPhotos().size());
            firstUser.likePhoto(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1));
            entityManager.persist(secondUser);
            entityManager.persist(firstUser);
            log.info("User {} added like to user {} photo '{}'", firstUser.getName(), secondUser.getName(),
                    secondUser.getPhotos().get(secondUser.getPhotos().size() - 1).getTitle());
            //log.info("User {} has {} photos", secondUser.getName(), secondUser.getPhotos().size());
            firstUser.addComment(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1), "It's cool!");
            entityManager.persist(secondUser);
            entityManager.persist(firstUser);
            log.info("User {} added comment to user {} photos in his profile", firstUser.getName(), secondUser.getName());
            //secondUser.addLike(firstUser.getName());
            entityManager.persist(firstUser);
            entityManager.persist(secondUser);
            //log.info("User {} set like to user {} ", secondUser.getName(), firstUser.getName());
            secondUser.addComment(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1), "Thank's!");
            entityManager.persist(firstUser);
            entityManager.persist(secondUser);
            log.info("User {} added comment to user {} photos in his profile", secondUser.getName(), secondUser.getName());
            //secondUser.withdrawLike(firstUser.getLikes().get(0));
            entityManager.persist(firstUser);
            entityManager.persist(secondUser);
            //log.info("User {} withdrew like from user {}", secondUser.getName(), firstUser.getName());

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

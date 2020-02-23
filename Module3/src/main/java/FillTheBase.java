import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Scanner;

/***
 * This program has created as a module task "Data bases":
 * Into the imaginary social network there are Users (id, name), Photo (id, name, author) and Comments to Photo (id,
 * text, author, which Photo relates). All the Users has a possibilities to like another Users, Photos and Comments to
 * Photos. You should realize such possibilities:
 *
 *  • User can't like same entity twice (f.e. same Photo);
 *  • User can withdraw like;
 *  • need to be able to count a number of likes, that received by entity, and output the list of Users, who likes the
 *    entity;
 *  • the new entities may appear in the future, that can be liked.
 *
 *  Its recommended, follows the principles of normalization and mark links with the foreign keys (and at the DB level
 *  prevents the possibilities of like re-sending).
 *
 *  DBMS and ORM choosing - its a developer decision.
 */
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

            System.out.println("Enter the third user name: ");
            String thirdUserName = sc.next();
            User thirdUser = new User();
            thirdUser.setName(thirdUserName);
            entityManager.persist(thirdUser);
            log.info("User {} is created", thirdUserName);

            secondUser.addPhotos("My holiday");
            entityManager.persist(secondUser);
            log.info("User {} added {} photos in his profile", secondUser.getName(), secondUser.getPhotos().size());
            firstUser.likePhoto(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1));
            entityManager.persist(secondUser);
            entityManager.persist(firstUser);
            log.info("User {} liked user {} photo '{}'", firstUser.getName(), secondUser.getName(),
                    secondUser.getPhotos().get(secondUser.getPhotos().size() - 1).getTitle());

            thirdUser.likePhoto(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1));
            entityManager.persist(secondUser);
            entityManager.persist(thirdUser);
            log.info("User {} liked user {} photo '{}'", thirdUser.getName(), secondUser.getName(),
                    secondUser.getPhotos().get(secondUser.getPhotos().size() - 1).getTitle());

            firstUser.addComment(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1), "That's cool!");
            entityManager.persist(secondUser);
            entityManager.persist(firstUser);
            log.info("User {} added comment to user {} photos in his profile", firstUser.getName(), secondUser.getName());
            secondUser.likeUser(firstUser);
            secondUser.likeComment(firstUser.getComments().get(firstUser.getComments().size() - 1));
            entityManager.persist(firstUser);
            entityManager.persist(secondUser);
            log.info("User {} liked user {}", secondUser.getName(),
                    secondUser.getLikedUsers().stream().filter(data -> firstUser.equals(firstUser)).findFirst().get().getName());
            log.info("User {} liked user {} last comment", secondUser.getName(),
                    secondUser.getLikedUsers().stream().filter(data -> firstUser.equals(firstUser)).findFirst().get().getName());
            secondUser.addComment(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1), "Thank's!");
            entityManager.persist(firstUser);
            entityManager.persist(secondUser);
            log.info("User {} added comment to user {} photos in his profile", secondUser.getName(), secondUser.getName());
            thirdUser.withdrawLikesPhoto(secondUser.getPhotos().get(secondUser.getPhotos().size() - 1),
                    thirdUser.getLikedPhotos());
            entityManager.persist(firstUser);
            entityManager.persist(secondUser);
            log.info("User {} withdraw like from user {} photo", thirdUser.getName(), secondUser.getName());

            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

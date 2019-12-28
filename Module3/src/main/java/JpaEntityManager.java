import entity.Photo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class JpaEntityManager {
    private static final Logger log = LoggerFactory.getLogger(JpaEntityManager.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            EntityManager entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();

//            List<Object> likesResults = getQueryResults(entityManager, "select U.likes from User U");
//            int i = 0;
//            for (Object o :
//                    likesResults) {
//                likesArray.add((Like) o);
//                log.info("User {} set {} likes to user {}", likesArray.get(i).getUser(),
//                        likesArray.get(i).toString(), likesArray.get(i).getUser());
//                i++;
//            }
            List<Photo> photosArray = new ArrayList<>();
            List<Object> photosResults = getQueryResults(entityManager, "select U.photos from User U");
            int i = 0;
            for (Object o :
                    photosResults) {
                photosArray.add((Photo) o);
                log.info("User {} post {} photos in his/her account:", photosArray.get(i).getUser().getName(),
                        photosArray.size());
                log.info("\t - photo '{}' liked by user {} and has {} comments", photosArray.get(i).getTitle(),
                        photosArray.get(i).getWhoLikes().iterator().next().getName(), photosArray.get(i).getComments().size());
                i++;
            }

            entityManager.getTransaction().commit();
        }
    }

    static List<Object> getQueryResults(EntityManager entityManager, String isQuery) {
        Query query = entityManager.createQuery(isQuery);
        List<Object> resultList = query.getResultList();
        if (resultList.size() == 0) {
            System.err.println("No results!");
        }
        return resultList;
    }
}

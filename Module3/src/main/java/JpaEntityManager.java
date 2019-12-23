import entity.Like;
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
            List<Like> likesArray = new ArrayList<>();
            List<Object> likesResults = getQueryResults(entityManager, "select U.likes from User U");
            int i = 0;
            for (Object o :
                    likesResults) {
                likesArray.add((Like) o);
                log.info("User {} set {} likes to user {}", likesArray.get(i).getAuthor(),
                        likesArray.get(i).toString(), likesArray.get(i).getUser());
                i++;
            }
            List<Photo> photosArray = new ArrayList<>();
            List<Object> photosResults = getQueryResults(entityManager, "select U.photos from User U");
            i = 0;
            for (Object o :
                    photosResults) {
                photosArray.add((Photo) o);
                log.info("User {} post {} photos in his account:", photosArray.get(i).getAuthor(),
                        photosArray.get(i).toString());
                log.info("/t - photo {} has {} likes and {} comments", photosArray.get(i).getTitle(),
                        photosArray.get(i).getLikes(), photosArray.get(i).getComments());
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

import entity.Comment;
import entity.Photo;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class JpaEntityManager {
    private static final Logger log = LoggerFactory.getLogger(JpaEntityManager.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            EntityManager entityManager = sessionFactory.createEntityManager();
            entityManager.getTransaction().begin();

            List<Comment> likedComments = new ArrayList<>();
            List<Object> likedCommentsResults = getQueryResults(entityManager, "select U.comments from User U");
            int i = 0;
            for (Object o :
                    likedCommentsResults) {
                likedComments.add((Comment) o);
                log.info("User {} added {} comments to user {} photos", likedComments.get(i).getUser().getName(),
                        likedComments.get(i).getUser().getComments().size(),
                        likedComments.get(i).getUser().getComments().get(likedComments.get(i).getUser().getComments().size() - 1).getPhoto().getUser().getName());
                if (i > likedComments.get(i).getWhoLikesComments().size() - 1) continue;
                else
                    log.info("User {} liked user {} comments", likedComments.get(i).getWhoLikesComments().iterator().next().getName(),
                            likedComments.get(i).getUser().getName());
                i++;
            }

            List<Photo> photosArray = new ArrayList<>();
            List<Object> photosResults = getQueryResults(entityManager, "select U.photos from User U");
            i = 0;
            for (Object o :
                    photosResults) {
                photosArray.add((Photo) o);
                log.info("User {} posted {} photos in his/her account:", photosArray.get(i).getUser().getName(),
                        photosArray.size());
                if (i > photosArray.get(i).getWhoLikesPhotos().size() - 1) continue;
                else
                    log.info("\t - photo '{}' liked by user {} and has {} comments", photosArray.get(i).getTitle(),
                            photosArray.get(i).getWhoLikesPhotos().iterator().next().getName(), photosArray.get(i).getComments().size());
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

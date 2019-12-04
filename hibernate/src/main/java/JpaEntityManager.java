import entity.DailyReport;
import entity.Department;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class JpaEntityManager {
    private static final Logger log = LoggerFactory.getLogger(JpaEntityManager.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory;
             Scanner sc = new Scanner(System.in)
        ) {
            EntityManager entityManager = sessionFactory.createEntityManager();
            log.info("Creating initial data");
            System.out.println("Enter new department name: ");
            String depName = sc.nextLine();
            System.out.println("Enter the profit value: ");
            double profit = sc.nextDouble();
            addDepartmentAndReport(entityManager, depName, profit);
            log.info("Department with name {} created: ", depName);
            log.info("Profit {} has set for department with name {}: ", profit, depName);
            System.out.println("Enter the year for report getting:");
            String year = sc.nextLine();
            System.out.println(getReport(entityManager, year));
            IOtoFile readFromFile = new IOtoFile();
            readFromFile.writeToFile(getReport(entityManager, year), args[0]);
        }
    }

    private static void addDepartmentAndReport(EntityManager entityManager, String depName, Double profit) {
        try {
            entityManager.getTransaction().begin();

            Department department = new Department();
            department.setName(depName);

            entityManager.persist(department);

            LocalDate currentDate = LocalDate.now();
            DailyReport report = new DailyReport(department.getName().concat(currentDate.toString()));
            report.setProfit(profit);

            entityManager.persist(report);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public static List<?> getReport(EntityManager entityManager, String year) {
        List<?> reports = null;
        try {
            reports = (List<?>) entityManager.createQuery("select aQuery from DailyReport aQuery where YEAR (aQuery.date) =: year");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }




}

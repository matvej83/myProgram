import entity.DailyReport;
import entity.Department;
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

/***
 * This program has created as a part of the home task "Data export from the DB to csv-file":
 *
 * There are tables into the DB:
 *  • daily_reports, that contains: date, department id and benefit;
 *  • departments, that contains department name and it's description
 *
 * Write the program, that by using a JPA (Hibernate), extracted the data from the DB into the csv-file, that named
 * annual_report.csv. This file contains tables with two rows: department name and annual profit (year is entered by
 * a user)
 */
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
            int aYear = sc.nextInt();
            IOtoFile writeTo = new IOtoFile();
            List<?> result = getReport(entityManager, aYear);
            for (int i = 0; i < result.size(); i++) {
                log.info("{} department", result.get(i));
            }
            writeTo.writeToFile(getReport(entityManager, aYear), args[0]);
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
            report.setDepartment(department);

            entityManager.persist(report);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public static List<String> getReport(EntityManager entityManager, int aYear) {
        Query query = entityManager.createQuery("select aQuery from DailyReport aQuery where YEAR (aQuery.date) = :aYear", DailyReport.class);
        query.setParameter("aYear", aYear);
        List<DailyReport> resultList = query.getResultList();
        if (resultList.size() == 0) {
            System.err.println("No results!");
        }
        List<String> report = new ArrayList<>();
        for (DailyReport result :
                resultList) {
            report.add(result.getDepartment().getName() + "," + result.getProfit());
        }
        return report;
    }

}

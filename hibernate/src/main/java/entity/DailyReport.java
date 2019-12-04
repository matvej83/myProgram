package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_reports")

public class DailyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(name = "profit", nullable = true)
    private double profit;

    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false)
    private Department department;

    public DailyReport() {

    }

    public DailyReport(String name) {
        this.name = name;
        this.date = date;
        this.profit = profit;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Department getDepartment() {
        return department;
    }
}

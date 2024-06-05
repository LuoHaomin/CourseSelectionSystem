package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "course", schema = "hibernate", catalog = "hibernate")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 60)
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "time", nullable = true, length = 40)
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "credit", nullable = false, precision = 0) //credit 学分
    private double credit;

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "periods", nullable = false, length = 60)
    private String periods;

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    @Basic
    @Column(name = "capacity", nullable = true)
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

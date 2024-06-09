package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "course", schema = "hibernate", catalog = "hibernate")
public class CourseEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    private int id;

    public CourseEntity(String name, String time, double credit, String periods, Integer capacity) {

        this.name = name;
        this.time = time;
        this.credit = credit;
        this.periods = periods;
        this.capacity = capacity;
    }

    public CourseEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "name", nullable = false, length = 60)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "time", nullable = true, length = 40)
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "credit", nullable = false, precision = 0)
    private double credit;

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "periods", nullable = false, length = 60)
    private String periods;

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "capacity", nullable = true)
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

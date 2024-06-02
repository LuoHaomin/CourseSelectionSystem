package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "course", schema = "hibernate", catalog = "hibernate")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "number", nullable = false, length = -1)
    private String number;
    @Basic
    @Column(name = "teacher", nullable = true, length = 8)
    private String teacher;
    @Basic
    @Column(name = "time", nullable = true, length = 40)
    private String time;
    @Basic
    @Column(name = "periods", nullable = true, length = 60)
    private String periods;
    @Basic
    @Column(name = "credit", nullable = false, precision = 0)
    private double credit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}

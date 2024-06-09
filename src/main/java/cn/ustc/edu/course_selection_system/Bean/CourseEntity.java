package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "course", schema = "hibernate", catalog = "hibernate")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @Basic
    @Column(name = "time", nullable = true, length = 40)
    private String time;
    @Basic
    @Column(name = "credit", nullable = false, precision = 0)
    private double credit;
    @Basic
    @Column(name = "periods", nullable = false, length = 60)
    private String periods;
    @Basic
    @Column(name = "capacity", nullable = true)
    private Integer capacity;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<StudentCourseEntity> studentCoursesById;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<TeacherCourseEntity> teacherCoursesById;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Collection<StudentCourseEntity> getStudentCoursesById() {
        return studentCoursesById;
    }

    public void setStudentCoursesById(Collection<StudentCourseEntity> studentCoursesById) {
        this.studentCoursesById = studentCoursesById;
    }

    public Collection<TeacherCourseEntity> getTeacherCoursesById() {
        return teacherCoursesById;
    }

    public void setTeacherCoursesById(Collection<TeacherCourseEntity> teacherCoursesById) {
        this.teacherCoursesById = teacherCoursesById;
    }
}

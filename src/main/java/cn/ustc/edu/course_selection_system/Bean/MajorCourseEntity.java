package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "major_course", schema = "hibernate", catalog = "hibernate")
@IdClass(MajorCourseEntityPK.class)
public class MajorCourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_number", nullable = false, length = 60)
    private String courseNumber;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "major", nullable = false, length = 20)
    private String major;

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

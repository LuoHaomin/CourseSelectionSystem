package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "major_course", schema = "hibernate", catalog = "hibernate")
@jakarta.persistence.IdClass(cn.ustc.edu.course_selection_system.Bean.MajorCourseEntityPK.class)
public class MajorCourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "course_number", nullable = false, length = 60)
    private String courseNumber;

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "major", nullable = false, length = 20)
    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

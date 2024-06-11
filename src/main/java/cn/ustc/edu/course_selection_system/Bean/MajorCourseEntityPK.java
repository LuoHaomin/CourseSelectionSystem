package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class MajorCourseEntityPK implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorCourseEntityPK that = (MajorCourseEntityPK) o;
        return Objects.equals(courseNumber, that.courseNumber) && Objects.equals(major, that.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNumber, major);
    }
}

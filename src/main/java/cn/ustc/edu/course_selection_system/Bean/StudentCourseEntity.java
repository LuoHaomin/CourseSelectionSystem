package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "student_course", schema = "hibernate", catalog = "hibernate")
@jakarta.persistence.IdClass(cn.ustc.edu.course_selection_system.Bean.StudentCourseEntityPK.class)
public class StudentCourseEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "student_id", nullable = false, length = 20)
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "course_id", nullable = false)
    private int courseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "score", nullable = true, precision = 0)
    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "teacher_course", schema = "hibernate", catalog = "hibernate")
@jakarta.persistence.IdClass(cn.ustc.edu.course_selection_system.Bean.TeacherCourseEntityPK.class)
public class TeacherCourseEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "teacher_id", nullable = false, length = 20)
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
}

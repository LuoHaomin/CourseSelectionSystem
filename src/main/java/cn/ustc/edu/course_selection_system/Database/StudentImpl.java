package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntityPK;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * Get the student's information
     *
     * @param id student's id
     * @return StudentEntity
     */
    public StudentEntity getStudent(String id) {
        List<StudentEntity> studentList = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<StudentEntity> _studentList = session.createQuery("from StudentEntity where id = :id",
                            StudentEntity.class)
                    .setParameter("id", id)
                    .getResultList();
            studentList.addAll(_studentList);
        });
        return studentList.get(0);
    }

    /**
     * Update the student's information
     *
     * @param student student's information
     */
    public void updateStudent(StudentEntity student) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(
                            "update StudentEntity set name = :name, password = :password," +
                                    " phoneNumber = :phoneNumber, major = :major, " +
                                    "admissionYear = :admissionYear, gender = :gender " +
                                    "where id = :id")
                    .setParameter("name", student.getName())
                    .setParameter("password", student.getPassword())
                    .setParameter("phoneNumber", student.getPhoneNumber())
                    .setParameter("major", student.getMajor())
                    .setParameter("admissionYear", student.getAdmissionYear())
                    .setParameter("gender", student.getGender())
                    .setParameter("id", student.getId())
                    .executeUpdate();
        });
    }

    /**
     * Add a student to the database
     *
     * @param studentId student's id
     * @param studentName student's name
     * @param studentPassword student's password
     * @param phoneNUmber student's phone number
     * @param major student's major
     * @param admissionYear student's admission year
     * @param gender student's gender
     */
    public void addStudent(String studentId, String studentName, String studentPassword, String phoneNUmber,
                           String major, int admissionYear, String gender) {
        StudentEntity student = new StudentEntity();
        student.setId(studentId);
        student.setName(studentName);
        student.setPassword(studentPassword);
        student.setPhoneNumber(phoneNUmber);
        student.setMajor(major);
        student.setAdmissionYear(admissionYear);
        student.setGender(gender);
        sessionFactory.inTransaction(session -> {
            session.persist(student);
        });
    }

    /**
     * Add a student to the database
     * @param student StudentEntity information
     */
    public void addStudent(StudentEntity student) {
        sessionFactory.inTransaction(session -> {
            session.persist(student);
        });
    }

    /**
     * Delete a student from the database
     *
     * @param studentId student's id
     */
    public void deleteStudent(String studentId) {
        StudentEntity student = new StudentEntity();
        student.setId(studentId);
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("delete StudentCourseEntity where studentId = :studentId")
                    .setParameter("studentId", studentId)
                    .executeUpdate();
            session.createMutationQuery("delete StudentEntity where id = :studentId")
                    .setParameter("studentId", studentId)
                    .executeUpdate();
        });
    }

    /**
     * Add a course to the student's course list
     *
     * @param studentId student's id
     * @param courseId  course's id
     */
    @Deprecated
    public void AddCoursePair(String studentId, int courseId) {
        StudentCourseEntity studentCourse = new StudentCourseEntity();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        studentCourse.setScore(0.0);
        sessionFactory.inTransaction(session -> {
            session.persist(studentCourse);
        });
    }

    /**
     * Delete a course from the student's course list
     *
     * @param studentId student's id
     * @param courseId  course's id
     */
    @Deprecated
    public void DeleteCoursePair(String studentId, int courseId) {
        StudentCourseEntityPK studentCourseEntityPK = new StudentCourseEntityPK();
        studentCourseEntityPK.setStudentId(studentId);
        studentCourseEntityPK.setCourseId(courseId);
        sessionFactory.inTransaction(session -> {
            session.remove(session.get(StudentCourseEntity.class, studentCourseEntityPK));
        });
    }


}

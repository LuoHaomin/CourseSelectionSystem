package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "student", schema = "hibernate", catalog = "hibernate")
public class StudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 20)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 8)
    private String name;
    @Basic
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 14)
    private String phoneNumber;
    @Basic
    @Column(name = "major", nullable = true, length = 20)
    private String major;
    @Basic
    @Column(name = "admissionYear", nullable = false)
    private int admissionYear;
    @Basic
    @Column(name = "gender", nullable = false, length = 1)
    private String gender;
    @OneToMany(mappedBy = "studentByStudentId")
    private Collection<StudentCourseEntity> studentCoursesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Collection<StudentCourseEntity> getStudentCoursesById() {
        return studentCoursesById;
    }

    public void setStudentCoursesById(Collection<StudentCourseEntity> studentCoursesById) {
        this.studentCoursesById = studentCoursesById;
    }
}

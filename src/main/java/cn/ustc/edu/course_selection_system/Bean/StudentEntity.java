package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student", schema = "hibernate", catalog = "hibernate")
public class StudentEntity extends PersonInfo{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
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
    @Column(name = "position", nullable = false, length = 10)
    private String position;

    public StudentEntity(int id, String name, String password, String phoneNumber, String major, int admissionYear) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.admissionYear = admissionYear;
    }

    public StudentEntity() {

    }

//    @ManyToMany
//    @JoinTable(name = "student_course", schema = "hibernate", catalog = "hibernate",
//            joinColumns = @JoinColumn(name = "student", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "course", referencedColumnName = "id", nullable = false))
//    private Set<CourseEntity> courses;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

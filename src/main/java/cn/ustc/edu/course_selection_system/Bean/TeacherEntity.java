package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher", schema = "hibernate", catalog = "hibernate")
public class TeacherEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 20)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 8)
    private String name;
    @Basic
    @Column(name = "password", nullable = true, length = 60)
    private String password;
    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 14)
    private String phoneNumber;
    @Basic
    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

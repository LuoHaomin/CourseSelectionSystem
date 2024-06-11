package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "admin", schema = "hibernate", catalog = "hibernate")
public class AdminEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

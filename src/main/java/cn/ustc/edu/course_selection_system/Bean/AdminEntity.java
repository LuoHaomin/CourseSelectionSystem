package cn.ustc.edu.course_selection_system.Bean;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "admin", schema = "hibernate", catalog = "hibernate")
public class AdminEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "password", nullable = false, length = 128)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

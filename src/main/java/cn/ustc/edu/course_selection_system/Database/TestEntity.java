package cn.ustc.edu.course_selection_system.Database;

import javax.persistence.*;

@Entity
@Table(name = "test", schema = "hibernate")
public class TestEntity {

    @Id
    @Column(name = "id", nullable = true)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

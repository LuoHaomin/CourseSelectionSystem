package cn.ustc.edu.course_selection_system.Bean;

public class Admin {
    private int id;
    private String passwd;
    private String position;

    public Admin(int id, String passwd, String position) {
        this.id = id;
        this.passwd = passwd;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

package entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;

    @Column
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
package ua.library.pak.Library.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;


    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

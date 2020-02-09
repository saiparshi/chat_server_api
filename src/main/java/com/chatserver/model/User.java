package com.chatserver.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: Sagarica Parshi
 * Mongo collection for User CURD
 */
@Document(collection = "User")
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private boolean loggedIn;

    public User(String id, String userName, String password, boolean loggedIn){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
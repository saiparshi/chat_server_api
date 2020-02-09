package com.chatserver.model;

public class UserRequest {
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    private String userName;
    private String password;
    private boolean loggedIn;
}
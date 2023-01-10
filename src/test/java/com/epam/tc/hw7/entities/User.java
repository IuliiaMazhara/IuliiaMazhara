package com.epam.tc.hw7.entities;


import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {
    public static final  User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String userName;
    private final String password;
    private final String fullName;

    public User(String login, String password, String fullName) {
        this.userName = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}

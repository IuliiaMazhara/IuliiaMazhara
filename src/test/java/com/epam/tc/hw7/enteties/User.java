package com.epam.tc.hw7.enteties;


public class User {
    public static final  User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String userName;
    private String password;
    private String fullName;

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

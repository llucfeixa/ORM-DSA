package edu.upc.eetac.dsa.model;

public class User {
    private String userId;
    private String userName;
    private String userSurname;
    private String userBirth;
    private String email;
    private String password;
    public User() {
    }

    public User(String userId, String userName, String userSurname, String userBirth, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userBirth = userBirth;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
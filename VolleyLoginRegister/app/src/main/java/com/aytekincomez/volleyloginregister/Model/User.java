package com.aytekincomez.volleyloginregister.Model;

public class User {
    private int id;
    private String nameUsername;
    private String email;
    private String password;
    private String country;
    private String city;

    public User() {
    }

    public User(int id, String nameUsername, String email, String password, String country, String city) {
        this.id = id;
        this.nameUsername = nameUsername;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUsername() {
        return nameUsername;
    }

    public void setNameUsername(String nameUsername) {
        this.nameUsername = nameUsername;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

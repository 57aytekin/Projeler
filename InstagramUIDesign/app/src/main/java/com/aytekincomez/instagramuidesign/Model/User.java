package com.aytekincomez.instagramuidesign.Model;

public class User {
    private int userid;
    private String username;
    private String email;
    private String password;
    private String nameSurname;
    private String description;
    private String profilePhoto;
    private String website;
    private String phoneNumber;
    private String gender;      //m, f
    private String registerIp;
    private String registerDate;
    private int verified_user; // 1 = onaylanmış hesap, 0 = normal hesap
    private int private_mode;  // 1 = hesap gizli, 0 = herkeses acık
    private int business_mode; // 1 = ticari hesap, 0 = kişisel hesap

    public User() {
    }

    public User(int userid, String username, String email, String password, String nameSurname, String description, String profilePhoto, String website, String phoneNumber, String gender, String registerIp, String registerDate, int verified_user, int private_mode, int business_mode) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nameSurname = nameSurname;
        this.description = description;
        this.profilePhoto = profilePhoto;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.registerIp = registerIp;
        this.registerDate = registerDate;
        this.verified_user = verified_user;
        this.private_mode = private_mode;
        this.business_mode = business_mode;
    }

    public int getId() {
        return userid;
    }

    public void setId(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getVerified_user() {
        return verified_user;
    }

    public void setVerified_user(int verified_user) {
        this.verified_user = verified_user;
    }

    public int getPrivate_mode() {
        return private_mode;
    }

    public void setPrivate_mode(int private_mode) {
        this.private_mode = private_mode;
    }

    public int getBusiness_mode() {
        return business_mode;
    }

    public void setBusiness_mode(int business_mode) {
        this.business_mode = business_mode;
    }
}


package com.ebookfrenzy.restproject;

import java.util.ArrayList;

public class Names {
    private String age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;

    private ArrayList<Names> names;

    public ArrayList<Names> getNameList() {
        return names;
    }

    //METHODS FOR GETTING AND SETTING EACH COUPON
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
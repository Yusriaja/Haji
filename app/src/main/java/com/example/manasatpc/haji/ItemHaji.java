package com.example.manasatpc.haji;

/**
 * Created by ManasatPC on 01/08/18.
 */

public class ItemHaji {
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSequance() {
        return sequance;
    }

    public void setSequance(String sequance) {
        this.sequance = sequance;
    }

    public int getUser_admin() {
        return user_admin;
    }

    public void setUser_admin(int user_admin) {
        this.user_admin = user_admin;
    }

    private String last_name, first_name,email,password,phone, sequance ;
    int  user_admin;
}

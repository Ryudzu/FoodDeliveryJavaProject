package com.jdbc.data;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerData {

    private final Pattern ptEmail = Pattern.compile("(^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$)");
    private final Pattern ptPassword = Pattern.compile("(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).{8,}$)");

    private Matcher mt;

    private int id;
    private String customerPhone;
    private String email;
    private String password;
    private String username;
    private Timestamp accountRegistered;

    public CustomerData() {}

    public CustomerData(int id, String customerPhone, String email, String password, String username, Timestamp accountRegistered) {
        this.id = id;
        this.customerPhone = customerPhone;
        this.email = email;
        this.password = password;
        this.username = username;
        this.accountRegistered = accountRegistered;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "id=" + id +
                ", customerPhone=" + customerPhone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", accountRegistered='" + accountRegistered + '\'' +
                '}';
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

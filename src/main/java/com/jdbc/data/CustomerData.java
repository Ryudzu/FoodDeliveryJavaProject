package com.jdbc.data;

public class CustomerData {

    private int id;
    private String customerPhone;
    private String email;
    private String password;
    private String username;

    public CustomerData() {}

    public CustomerData(int id, String customerPhone, String email, String password, String username) {
        this.id = id;
        this.customerPhone = customerPhone;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "id=" + id +
                ", customerPhone=" + customerPhone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

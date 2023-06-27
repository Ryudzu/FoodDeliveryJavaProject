package model.data;

import java.sql.Timestamp;

public class CustomerData {

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

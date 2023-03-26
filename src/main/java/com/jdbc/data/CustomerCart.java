package com.jdbc.data;

public class CustomerCart {

    private int id;
    private int customerDataId;

    public CustomerCart() {}

    public CustomerCart(int id, int customerDataId) {
        this.id = id;
        this.customerDataId = customerDataId;
    }

    @Override
    public String toString() {
        return "CustomerCart{" +
                "id=" + id +
                ", customerDataId=" + customerDataId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerDataId() {
        return customerDataId;
    }

    public void setCustomerDataId(int customerDataId) {
        this.customerDataId = customerDataId;
    }
}

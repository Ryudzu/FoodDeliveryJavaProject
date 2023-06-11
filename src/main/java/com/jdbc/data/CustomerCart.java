package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

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

    public int getCustomerDataId() {
        return customerDataId;
    }

    public void setCustomerDataId(int customerDataId) throws PersonalExceptions {
        if (customerDataId > 0) this.customerDataId = customerDataId;
        else throw new PersonalExceptions("ID пользователя в CustomerCart невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

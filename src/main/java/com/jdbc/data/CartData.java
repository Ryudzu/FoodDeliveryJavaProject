package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

public class CartData {

    private int id;
    private int amount;
    private int productDataId;
    private int customerCartId;

    public CartData() {}

    public CartData(int id, int amount, int productDataId, int customerCartId) {
        this.id = id;
        this.amount = amount;
        this.productDataId = productDataId;
        this.customerCartId = customerCartId;
    }

    @Override
    public String toString() {
        return "CartData{" +
                "id=" + id +
                ", amount=" + amount +
                ", productDataId=" + productDataId +
                ", customerCartId=" + customerCartId +
                '}';
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) throws PersonalExceptions {
        if (amount >= 0 && amount <= 99) this.amount = amount;
        else throw new PersonalExceptions("Количество товаров в CartData невалидно! Оно не может быть отрицательным или больше 99.");
    }

    public int getProductDataId() {
        return productDataId;
    }

    public void setProductDataId(int productDataId) throws PersonalExceptions {
        if (productDataId > 0) this.productDataId = productDataId;
        else throw new PersonalExceptions("ID товара в CartData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public int getCustomerCartId() {
        return customerCartId;
    }

    public void setCustomerCartId(int customerCartId) throws PersonalExceptions {
        if (customerCartId > 0) this.customerCartId = customerCartId;
        else throw new PersonalExceptions("ID пользователя в CartData невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

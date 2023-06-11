package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

import java.sql.Time;
import java.sql.Timestamp;

public class ProductAndOrder {

    private int amountOrdered;
    private Timestamp timeOrdered;
    private int orderDataId;
    private int productDataId;

    public ProductAndOrder() {}

    public ProductAndOrder(int amountOrdered, Timestamp timeOrdered, int orderDataId, int productDataId) {
        this.amountOrdered = amountOrdered;
        this.timeOrdered = timeOrdered;
        this.orderDataId = orderDataId;
        this.productDataId = productDataId;
    }

    @Override
    public String toString() {
        return "ProductAndOrder{" +
                "amountOrdered=" + amountOrdered +
                ", timeOrdered=" + timeOrdered +
                ", orderDataId=" + orderDataId +
                ", productDataId=" + productDataId +
                '}';
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) throws PersonalExceptions {
        if (amountOrdered >= 0 && amountOrdered <= 99) this.amountOrdered = amountOrdered;
        else throw new PersonalExceptions("Количество товаров в ProductAndOrder невалидно! Оно не может быть отрицательным или больше 99.");
    }

    public int getOrderDataId() {
        return orderDataId;
    }

    public void setOrderDataId(int orderDataId) throws PersonalExceptions {
        if (orderDataId > 0) this.orderDataId = orderDataId;
        else throw new PersonalExceptions("ID заказа в ProductAndOrder невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public int getProductDataId() {
        return productDataId;
    }

    public void setProductDataId(int productDataId) throws PersonalExceptions {
        if (productDataId > 0) this.productDataId = productDataId;
        else throw new PersonalExceptions("ID товара в ProductAndOrder невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

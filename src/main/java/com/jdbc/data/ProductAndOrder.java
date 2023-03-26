package com.jdbc.data;

public class ProductAndOrder {

    private int amountOrdered;
    private int orderDataId;
    private int productDataId;

    public ProductAndOrder() {}

    public ProductAndOrder(int amountOrdered, int orderDataId, int productDataId) {
        this.amountOrdered = amountOrdered;
        this.orderDataId = orderDataId;
        this.productDataId = productDataId;
    }

    @Override
    public String toString() {
        return "ProductAndOrder{" +
                "amountOrdered=" + amountOrdered +
                ", orderDataId=" + orderDataId +
                ", productDataId=" + productDataId +
                '}';
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    public int getOrderDataId() {
        return orderDataId;
    }

    public void setOrderDataId(int orderDataId) {
        this.orderDataId = orderDataId;
    }

    public int getProductDataId() {
        return productDataId;
    }

    public void setProductDataId(int productDataId) {
        this.productDataId = productDataId;
    }
}

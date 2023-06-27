package model.data;

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

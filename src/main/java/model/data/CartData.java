package model.data;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProductDataId() {
        return productDataId;
    }

    public void setProductDataId(int productDataId) {
        this.productDataId = productDataId;
    }

    public int getCustomerCartId() {
        return customerCartId;
    }

    public void setCustomerCartId(int customerCartId) {
        this.customerCartId = customerCartId;
    }
}

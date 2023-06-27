package model.data;

public class ProductsInCart {

    private int id;
    private String productTitle;
    private int productDataId;
    private double price;
    private int amount;

    public ProductsInCart(int id, String productTitle, int productDataId, double price, int amount) {
        this.id = id;
        this.productTitle = productTitle;
        this.productDataId = productDataId;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductsInCart{" +
                "id=" + id +
                ", productTitle='" + productTitle + '\'' +
                ", productDataId=" + productDataId +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductDataId() {
        return productDataId;
    }

    public void setProductDataId(int productDataId) {
        this.productDataId = productDataId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

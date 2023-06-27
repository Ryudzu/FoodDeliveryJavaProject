package model.data;

public class ProductData {

    private int id;
    private String imageLink;
    private double price;
    private int productCategoryId;
    private int productRating;
    private String productTitle;

    public ProductData() {}

    public ProductData(int id, String imageLink, double price, int productCategoryId, int productRating, String productTitle) {
        this.id = id;
        this.imageLink = imageLink;
        this.price = price;
        this.productCategoryId = productCategoryId;
        this.productRating = productRating;
        this.productTitle = productTitle;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "id=" + id +
                ", imageLink=" + imageLink +
                ", price=" + price +
                ", productCategoryId=" + productCategoryId +
                ", productRating=" + productRating +
                ", productTitle='" + productTitle + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}

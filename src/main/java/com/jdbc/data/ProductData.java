package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductData {

    private final Pattern ptProductTitle = Pattern.compile("(^([А-Я][а-я]{4,})$)");

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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws PersonalExceptions {
        if (price > 0 && price < 1000) this.price = price;
        else throw new PersonalExceptions("Стоимость товара в ProductData невалидна! Она не может быть отрицательной, равной нулю и должна иметь два знака после запятой (максимально допустимое значение 1000)ф.");
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) throws PersonalExceptions {
        if (productCategoryId > 0) this.productCategoryId = productCategoryId;
        else throw new PersonalExceptions("ID категории товара в ProductData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) throws PersonalExceptions {
        if (productRating >= 1 && productRating < 6) this.productRating = productRating;
        else throw new PersonalExceptions("Рейтинг товара в ProductData невалидный! Он не может быть меньше 1 и больше 5.");
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) throws PersonalExceptions {
        Matcher mt = ptProductTitle.matcher(productTitle);
        if (mt.matches() && productTitle.length() <= 30) this.productTitle = productTitle;
        else throw new PersonalExceptions("Название товара в ProductData невалидно! Оно не должно содержать в себе цифр и должно быть больше 3-х символов (максимально допустимое значение 30 символов).");
    }
}

package com.jdbc.validator;

import com.jdbc.data.ProductData;
import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ProductDataValidator {

    public static final ProductData product = new ProductData();

    private final Pattern ptProductTitle = Pattern.compile("(^([А-Я][а-я]{4,})$)");

    public ProductDataValidator() {}

    public ProductDataValidator(String imageLink, double price, int productCategoryId, int productRating, String productTitle) throws PersonalExceptions {
        ValidateImageLink(imageLink);
        ValidatePrice(price);
        ValidateProductCategoryId(productCategoryId);
        ValidateProductRating(productRating);
        ValidateProductTitle(productTitle);
    }

    public void ValidateImageLink(String imageLink) {
        product.setImageLink(imageLink);
    }

    public void ValidatePrice(double price) throws PersonalExceptions {
        if (price > 0 && price < 1000) product.setPrice(price);
        else throw new PersonalExceptions("Стоимость товара в ProductData невалидна! Она не может быть отрицательной, равной нулю и должна иметь два знака после запятой (максимально допустимое значение 1000).");
    }

    public void ValidateProductCategoryId(int productCategoryId) throws PersonalExceptions {
        if (productCategoryId > 0) product.setProductCategoryId(productCategoryId);
        else throw new PersonalExceptions("ID категории товара в ProductData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void ValidateProductRating(int productRating) throws PersonalExceptions {
        if (productRating >= 1 && productRating < 6) product.setProductRating(productRating);
        else throw new PersonalExceptions("Рейтинг товара в ProductData невалидный! Он не может быть меньше 1 и больше 5.");
    }

    public void ValidateProductTitle(String productTitle) throws PersonalExceptions {
        Matcher mt = ptProductTitle.matcher(productTitle);
        if (mt.matches() && productTitle.length() <= 30) product.setProductTitle(productTitle);
        else throw new PersonalExceptions("Название товара в ProductData невалидно! Оно не должно содержать в себе цифр и должно быть больше 3-х символов (максимально допустимое значение 30 символов).");
    }
}

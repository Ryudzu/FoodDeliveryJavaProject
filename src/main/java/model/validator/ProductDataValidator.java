package model.validator;

import model.data.ProductData;
import model.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ProductDataValidator {

    public static final ProductData product = new ProductData();

    private final Pattern ptProductTitle = Pattern.compile("(^([А-Я][а-я]{4,})$)");

    public ProductDataValidator() {}

    public ProductDataValidator(String imageLink, double price, int productCategoryId, int productRating, String productTitle) throws PersonalExceptions {
        validateImageLink(imageLink);
        validatePrice(price);
        validateProductCategoryId(productCategoryId);
        validateProductRating(productRating);
        validateProductTitle(productTitle);
    }

    public void validateImageLink(String imageLink) {
        product.setImageLink(imageLink);
    }

    public void validatePrice(double price) throws PersonalExceptions {
        if (price > 0 && price < 1000) product.setPrice(price);
        else throw new PersonalExceptions("Стоимость товара в ProductData невалидна! Она не может быть отрицательной, равной нулю и должна иметь два знака после запятой (максимально допустимое значение 1000).");
    }

    public void validateProductCategoryId(int productCategoryId) throws PersonalExceptions {
        if (productCategoryId > 0) product.setProductCategoryId(productCategoryId);
        else throw new PersonalExceptions("ID категории товара в ProductData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void validateProductRating(int productRating) throws PersonalExceptions {
        if (productRating >= 1 && productRating < 6) product.setProductRating(productRating);
        else throw new PersonalExceptions("Рейтинг товара в ProductData невалидный! Он не может быть меньше 1 и больше 5.");
    }

    public void validateProductTitle(String productTitle) throws PersonalExceptions {
        Matcher mt = ptProductTitle.matcher(productTitle);
        if (mt.matches() && productTitle.length() <= 30) product.setProductTitle(productTitle);
        else throw new PersonalExceptions("Название товара в ProductData невалидно! Оно не должно содержать в себе цифр и должно быть больше 3-х символов (максимально допустимое значение 30 символов).");
    }
}

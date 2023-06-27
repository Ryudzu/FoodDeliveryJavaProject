package model.validator;

import model.data.ProductAndOrder;
import model.exceptions.PersonalExceptions;

public final class ProductAndOrderValidator {

    public static final ProductAndOrder productAndOrder = new ProductAndOrder();

    public ProductAndOrderValidator() {}

    public ProductAndOrderValidator(int amountOrdered, int orderDataId, int productDataId) throws PersonalExceptions {
        validateAmountOrdered(amountOrdered);
        validateOrderDataId(orderDataId);
        validateProductDataId(productDataId);
    }

    public void validateAmountOrdered(int amountOrdered) throws PersonalExceptions {
        if (amountOrdered >= 0 && amountOrdered <= 99) productAndOrder.setAmountOrdered(amountOrdered);
        else throw new PersonalExceptions("Количество товаров в ProductAndOrder невалидно! Оно не может быть отрицательным или больше 99.");
    }

    public void validateOrderDataId(int orderDataId) throws PersonalExceptions {
        if (orderDataId > 0) productAndOrder.setOrderDataId(orderDataId);
        else throw new PersonalExceptions("ID заказа в ProductAndOrder невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void validateProductDataId(int productDataId) throws PersonalExceptions {
        if (productDataId > 0) productAndOrder.setProductDataId(productDataId);
        else throw new PersonalExceptions("ID товара в ProductAndOrder невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

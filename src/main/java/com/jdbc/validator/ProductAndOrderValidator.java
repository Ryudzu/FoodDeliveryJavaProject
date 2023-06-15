package com.jdbc.validator;

import com.jdbc.data.ProductAndOrder;
import com.jdbc.exceptions.PersonalExceptions;

public final class ProductAndOrderValidator {

    public static final ProductAndOrder productAndOrder = new ProductAndOrder();

    public ProductAndOrderValidator() {}

    public ProductAndOrderValidator(int amountOrdered, int orderDataId, int productDataId) throws PersonalExceptions {
        ValidateAmountOrdered(amountOrdered);
        ValidateOrderDataId(orderDataId);
        ValidateProductDataId(productDataId);
    }

    public void ValidateAmountOrdered(int amountOrdered) throws PersonalExceptions {
        if (amountOrdered >= 0 && amountOrdered <= 99) productAndOrder.setAmountOrdered(amountOrdered);
        else throw new PersonalExceptions("Количество товаров в ProductAndOrder невалидно! Оно не может быть отрицательным или больше 99.");
    }

    public void ValidateOrderDataId(int orderDataId) throws PersonalExceptions {
        if (orderDataId > 0) productAndOrder.setOrderDataId(orderDataId);
        else throw new PersonalExceptions("ID заказа в ProductAndOrder невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void ValidateProductDataId(int productDataId) throws PersonalExceptions {
        if (productDataId > 0) productAndOrder.setProductDataId(productDataId);
        else throw new PersonalExceptions("ID товара в ProductAndOrder невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

package com.jdbc.validator;

import com.jdbc.data.CartData;
import com.jdbc.exceptions.PersonalExceptions;

public final class CartDataValidator {

    public static final CartData cart = new CartData();

    public CartDataValidator() {}

    public CartDataValidator(int amount, int productDataId, int customerCartId) throws PersonalExceptions {
        ValidateAmount(amount);
        ValidateProductDataId(productDataId);
        ValidateCustomerCartId(customerCartId);
    }

    public void ValidateAmount(int amount) throws PersonalExceptions {
        if (amount >= 0 && amount <= 99) cart.setAmount(amount);
        else throw new PersonalExceptions("Количество товаров в CartData невалидно! Оно не может быть отрицательным или больше 99.");
    }

    public void ValidateProductDataId(int productDataId) throws PersonalExceptions {
        if (productDataId > 0) cart.setProductDataId(productDataId);
        else throw new PersonalExceptions("ID товара в CartData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void ValidateCustomerCartId(int customerCartId) throws PersonalExceptions {
        if (customerCartId > 0) cart.setCustomerCartId(customerCartId);
        else throw new PersonalExceptions("ID пользователя в CartData невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

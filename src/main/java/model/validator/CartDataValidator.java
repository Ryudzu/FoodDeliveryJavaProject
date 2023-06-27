package model.validator;

import model.data.CartData;
import model.exceptions.PersonalExceptions;

public final class CartDataValidator {

    public static final CartData cart = new CartData();

    public CartDataValidator() {}

    public CartDataValidator(int amount, int productDataId, int customerCartId) throws PersonalExceptions {
        validateAmount(amount);
        validateProductDataId(productDataId);
        validateCustomerCartId(customerCartId);
    }

    public void validateAmount(int amount) throws PersonalExceptions {
        if (amount >= 0 && amount <= 99) cart.setAmount(amount);
        else throw new PersonalExceptions("Количество товаров в CartData невалидно! Оно не может быть отрицательным или больше 99.");
    }

    public void validateProductDataId(int productDataId) throws PersonalExceptions {
        if (productDataId > 0) cart.setProductDataId(productDataId);
        else throw new PersonalExceptions("ID товара в CartData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void validateCustomerCartId(int customerCartId) throws PersonalExceptions {
        if (customerCartId > 0) cart.setCustomerCartId(customerCartId);
        else throw new PersonalExceptions("ID пользователя в CartData невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

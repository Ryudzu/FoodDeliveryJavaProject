package com.jdbc.validator;

import com.jdbc.data.CustomerCart;
import com.jdbc.exceptions.PersonalExceptions;

public final class CustomerCartValidator {

    public static final CustomerCart customerCart = new CustomerCart();

    public CustomerCartValidator() {}

    public CustomerCartValidator(int customerDataId) throws PersonalExceptions {
        ValidateCustomerDataId(customerDataId);
    }

    public void ValidateCustomerDataId(int customerDataId) throws PersonalExceptions {
        if (customerDataId > 0) customerCart.setCustomerDataId(customerDataId);
        else throw new PersonalExceptions("ID пользователя в CustomerCart невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

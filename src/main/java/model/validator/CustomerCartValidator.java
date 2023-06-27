package model.validator;

import model.data.CustomerCart;
import model.exceptions.PersonalExceptions;

public final class CustomerCartValidator {

    public static final CustomerCart customerCart = new CustomerCart();

    public CustomerCartValidator() {}

    public CustomerCartValidator(int customerDataId) throws PersonalExceptions {
        validateCustomerDataId(customerDataId);
    }

    public void validateCustomerDataId(int customerDataId) throws PersonalExceptions {
        if (customerDataId > 0)
            customerCart.setCustomerDataId(customerDataId);
        else
            throw new PersonalExceptions("ID пользователя в CustomerCart невалидный! Он не может быть отрицательным или равным нулю.");
    }
}

package controller.services;

import model.crud.CRUDutils;
import model.data.CustomerData;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService implements Authentication {

    private final List<CustomerData> customers = new ArrayList<>(CRUDutils.showAllCustomerData());
    private CustomerData customer = null;

    @Override
    public boolean isUserExists(String username) {
        for (CustomerData customerData : customers) {
            customer = customerData;
            if (customer.getUsername().equals(username))
                return true;
        }
        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        for (CustomerData customerData : customers) {
            customer = customerData;
            if (customer.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean isPhoneExists(String phone) {
        for (CustomerData customerData : customers) {
            customer = customerData;
            if (customer.getCustomerPhone().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean arePasswordsEqual(String password, String passwordDuplicate) {
        return password.equals(passwordDuplicate);
    }

    @Override
    public boolean isUserAuthorized(String username, String password) {
        return CRUDutils.isCustomerExists(username, DigestUtils.md5Hex(password));
    }

    @Override
    public int getIdCustomerCart(String username) {
        return CRUDutils.showCustomerId(username);
    }
}

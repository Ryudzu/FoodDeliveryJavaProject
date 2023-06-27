package controller.services;

import model.crud.CRUDutils;
import model.data.CustomerData;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationService implements Authentication, Serializable {

    private final List<CustomerData> customers = new ArrayList<>(CRUDutils.showAllCustomerData());
    private transient CustomerData customer = null;

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
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] hashedBytes = md.digest(passwordBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1)
                    hexString.append('0');

                hexString.append(hex);
            }

            String hashedPassword = hexString.toString();

            return CRUDutils.isCustomerExists(username, hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public int getIdCustomerCart(String username) {
        return CRUDutils.showCustomerId(username);
    }
}

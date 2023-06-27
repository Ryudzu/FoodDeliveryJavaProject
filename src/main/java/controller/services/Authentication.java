package controller.services;

public interface Authentication {
    boolean arePasswordsEqual(String password, String passwordDuplicate);
    boolean isUserExists(String username);
    boolean isEmailExists(String email);
    boolean isPhoneExists(String phone);

    boolean isUserAuthorized(String username, String password);

    int getIdCustomerCart(String username);
}

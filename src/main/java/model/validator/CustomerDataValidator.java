package model.validator;

import model.data.CustomerData;
import model.exceptions.PersonalExceptions;
import org.apache.commons.codec.digest.DigestUtils;
import org.postgresql.util.MD5Digest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomerDataValidator {

    public static final CustomerData customer = new CustomerData();

    private final Pattern ptEmail = Pattern.compile("(^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$)");
    private final Pattern ptPassword = Pattern.compile("(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).{8,}$)");

    private Matcher mt;

    public CustomerDataValidator() {}

    public CustomerDataValidator(String customerPhone, String email, String password, String username) throws PersonalExceptions {
        validateCustomerPhone(customerPhone);
        validateEmail(email);
        validatePassword(password);
        validateUsername(username);
    }

    public void validateCustomerPhone(String customerPhone) throws PersonalExceptions {
        if (customerPhone.length() == 13) customer.setCustomerPhone(customerPhone);
        else throw new PersonalExceptions("Номер телефона в CustomerData невалидный! Он должен состоять из 13 символов: знак +, код страны (375), код сотового оператора (29), семизначный номер телефона.");
    }

    public void validateEmail(String email) throws PersonalExceptions {
        mt = ptEmail.matcher(email);
        if (mt.matches() && email.length() <= 256) customer.setEmail(email);
        else throw new PersonalExceptions("Название электронной почты в CustomerData невалидно! Оно должно состоять из менее, чем 256 символов и включать себя: название почты (blaguladzimir), знак '@', доменное имя (gmail.com).");
    }

    public void validatePassword(String password) throws PersonalExceptions {
        mt = ptPassword.matcher(password);
        if (mt.matches() && password.length() <= 35) customer.setPassword(DigestUtils.md5Hex(password));
        else throw new PersonalExceptions("Пароль в CustomerData невалидный! Требования при создании пароля: минимальная длина - 8 символов, максимальная длина - 35 символов, сочетание больших и маленьких букв, наличие цифр и специальных символов, отсутствие последовательных повторений (например, 1111), последовательных дат (например, 2000), имени пользователя и других очевидных или личных данных.");
    }

    public void validateUsername(String username) throws PersonalExceptions {
        if (username.length() >= 4 && username.length() <= 40) customer.setUsername(username);
        else throw new PersonalExceptions("Логин в CustomerData невалидный! Длина логина должна быть от 4 символов и выше (предельно допустимое значение 40 символов).");
    }
}

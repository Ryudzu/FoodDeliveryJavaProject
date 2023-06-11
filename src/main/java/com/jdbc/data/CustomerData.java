package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerData {

    private final Pattern ptEmail = Pattern.compile("(^([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$)");
    private final Pattern ptPassword = Pattern.compile("(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).{8,}$)");

    private Matcher mt;

    private int id;
    private String customerPhone;
    private String email;
    private String password;
    private String username;
    private Timestamp accountRegistered;

    public CustomerData() {}

    public CustomerData(int id, String customerPhone, String email, String password, String username, Timestamp accountRegistered) {
        this.id = id;
        this.customerPhone = customerPhone;
        this.email = email;
        this.password = password;
        this.username = username;
        this.accountRegistered = accountRegistered;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "id=" + id +
                ", customerPhone=" + customerPhone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", accountRegistered='" + accountRegistered + '\'' +
                '}';
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) throws PersonalExceptions {
        if (customerPhone.length() == 13) this.customerPhone = customerPhone;
        else throw new PersonalExceptions("Номер телефона в CustomerData невалидный! Он должен состоять из 13 символов: знак +, код страны (375), код сотового оператора (29), семизначный номер телефона.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws PersonalExceptions {
        mt = ptEmail.matcher(email);
        if (mt.matches() && email.length() <= 256) this.email = email;
        else throw new PersonalExceptions("Название электронной почты в CustomerData невалидно! Оно должно состоять из менее, чем 256 символов и включать себя: название почты (blaguladzimir), знак '@', доменное имя (gmail.com).");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PersonalExceptions {
        mt = ptPassword.matcher(password);
        if (mt.matches() && password.length() <= 35) this.password = password;
        else throw new PersonalExceptions("Пароль в CustomerData невалидный! Требования при создании пароля: минимальная длина - 8 символов, максимальная длина - 35 символов, сочетание больших и маленьких букв, наличие цифр и специальных символов, отсутствие последовательных повторений (например, 1111), последовательных дат (например, 2000), имени пользователя и других очевидных или личных данных.");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws PersonalExceptions {
        if (username.length() >= 4 && username.length() <= 40) this.username = username;
        else throw new PersonalExceptions("Логин в CustomerData невалидный! Длина логина должна быть от 4 символов и выше (предельно допустимое значение 40 символов).");
    }
}

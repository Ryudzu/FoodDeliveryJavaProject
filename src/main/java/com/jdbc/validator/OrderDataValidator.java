package com.jdbc.validator;

import com.jdbc.data.OrderData;
import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class OrderDataValidator {

    public static final OrderData order = new OrderData();

    private final Pattern ptAddress = Pattern.compile("(^([А-Я][а-я]+\\s\\d{2,},\\s)(кв\\.{1,4})$)");
    private final Pattern ptCity = Pattern.compile("(^[А-Я][а-я]{4,}$)");
    private final Pattern ptPayment = Pattern.compile("(Картой на сайте|Картой курьеру|Наличные)", Pattern.CANON_EQ);

    private Matcher mt;

    public OrderDataValidator() {}

    public OrderDataValidator(String address, String city, int courierDataId, int customerDataId, int floor, String payment, double total) throws PersonalExceptions {
        ValidateAddress(address);
        ValidateCity(city);
        ValidateCourierDataId(courierDataId);
        ValidateCustomerDataId(customerDataId);
        ValidateFloor(floor);
        ValidatePayment(payment);
        ValidateTotal(total);
    }

    public void ValidateAddress(String address) throws PersonalExceptions {
        mt = ptAddress.matcher(address);
        if (mt.matches() && address.length() <= 50) order.setAddress(address);
        else throw new PersonalExceptions("Название адреса в OrderData невалидно! Оно должно состоять из менее, чем 50 символов и включать в себя: название адреса (Притыцкого), номер дома (11), номер квартиры после запятой (кв. 11).");
    }

    public void ValidateCity(String city) throws PersonalExceptions {
        mt = ptCity.matcher(city);
        if (mt.matches() && city.length() <= 20) order.setCity(city);
        else throw new PersonalExceptions("Название города в OrderData невалидно! Он должен включать в себя от 4 символов и более (максимально допустимое значение 20 символов).");
    }

    public void ValidateCourierDataId(int courierDataId) throws PersonalExceptions {
        if (courierDataId > 0) order.setCourierDataId(courierDataId);
        else throw new PersonalExceptions("ID курьера в OrderData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void ValidateCustomerDataId(int customerDataId) throws PersonalExceptions {
        if (customerDataId > 0) order.setCustomerDataId(customerDataId);
        else throw new PersonalExceptions("ID пользователя в OrderData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public void ValidateFloor(int floor) throws PersonalExceptions {
        if (floor > 0 && floor <= 40) order.setFloor(floor);
        else throw new PersonalExceptions("Номер этажа в OrderData невалидный! Он не может быть отрицательным или равным нулю (максимально допустимое значение 40).");
    }

    public void ValidatePayment(String payment) throws PersonalExceptions {
        mt = ptPayment.matcher(payment);
        if (mt.matches() && payment.length() <= 20) order.setPayment(payment);
        else throw new PersonalExceptions("Название способа оплаты в OrderData невалидно! Примеры способов оплаты: 'Картой на сайте', 'Картой курьеру', 'Наличные' (максимально допустимое значение 20 символов).");
    }

    public void ValidateTotal(double total) throws PersonalExceptions {
        if (total > 0 && total < 10000) order.setTotal(total);
        else throw new PersonalExceptions("Итоговая стоимость заказа в OrderData невалидна! Она не может быть отрицательной, равной нулю и должна иметь два знака после запятой (максимально допустимое значение 10000).");
    }
}

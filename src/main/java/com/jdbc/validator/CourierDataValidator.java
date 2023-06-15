package com.jdbc.validator;

import com.jdbc.data.CourierData;
import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CourierDataValidator {

    public static final CourierData courier = new CourierData();

    private final Pattern pt = Pattern.compile( "(^[А-Я][а-я]+$)");
    private Matcher mt;

    public CourierDataValidator() {}

    public CourierDataValidator(String courierPhone, String firstname, String lastname, String vehicle) throws PersonalExceptions {
        ValidateCourierPhone(courierPhone);
        ValidateFirstname(firstname);
        ValidateLastname(lastname);
        ValidateVehicle(vehicle);
    }

    public void ValidateCourierPhone(String courierPhone) throws PersonalExceptions {
        if (courierPhone.length() == 13) courier.setCourierPhone(courierPhone);
        else throw new PersonalExceptions("Строка с номером телефона в CourierData невалидная! Она должна состоять из 13 символов: знак +, код страны (375), код сотового оператора (29), семизначный номер телефона.");
    }

    public void ValidateFirstname(String firstname) throws PersonalExceptions {
        mt = pt.matcher(firstname);
        if (mt.matches() && firstname.length() <= 16) courier.setFirstname(firstname);
        else throw new PersonalExceptions("Строка с именем в CourierData невалидная! Она может состоять только из букв русского алфавита и не может быть больше 16 символов, причем первая буква имени должна быть прописная.");
    }

    public void ValidateLastname(String lastname) throws PersonalExceptions {
        mt = pt.matcher(lastname);
        if (mt.matches() && lastname.length() <= 20) courier.setLastname(lastname);
        else throw new PersonalExceptions("Строка с фамилией в CourierData невалидная! Она может состоять только из букв русского алфавита и не может быть больше 20 символов, причем первая буква имени должна быть прописная.");
    }

    public void ValidateVehicle(String vehicle) throws PersonalExceptions {
        mt = pt.matcher(vehicle);
        if (mt.matches() && vehicle.length() <= 20) courier.setVehicle(vehicle);
        else throw new PersonalExceptions("Строка с названием транспорта в CourierData невалидная! Она может состоять только из букв русского алфавита и не может быть больше 20 символов, причем первая буква имени должна быть прописная.");
    }
}

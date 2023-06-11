package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourierData {

    private final Pattern pt = Pattern.compile( "(^[А-Я][а-я]+$)");
    private Matcher mt;

    private int id;
    private String courierPhone;
    private String firstname;
    private String lastname;
    private String vehicle;

    public CourierData() {}

    public CourierData(int id, String courierPhone, String firstname, String lastname, String vehicle) {
        this.id = id;
        this.courierPhone = courierPhone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "CourierData{" +
                "id=" + id +
                ", courierPhone=" + courierPhone +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", vehicle='" + vehicle + '\'' +
                '}';
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) throws PersonalExceptions{
        if (courierPhone.length() == 13) this.courierPhone = courierPhone;
        else throw new PersonalExceptions("Строка с номером телефона в CourierData невалидная! Она должна состоять из 13 символов: знак +, код страны (375), код сотового оператора (29), семизначный номер телефона.");
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) throws PersonalExceptions {
        mt = pt.matcher(firstname);
        if (mt.matches() && firstname.length() <= 16) this.firstname = firstname;
        else throw new PersonalExceptions("Строка с именем в CourierData невалидная! Она может состоять только из букв русского алфавита и не может быть больше 16 символов, причем первая буква имени должна быть прописная.");
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) throws PersonalExceptions {
        mt = pt.matcher(lastname);
        if (mt.matches() && lastname.length() <= 20) this.lastname = lastname;
        else throw new PersonalExceptions("Строка с фамилией в CourierData невалидная! Она может состоять только из букв русского алфавита и не может быть больше 20 символов, причем первая буква имени должна быть прописная.");
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) throws PersonalExceptions {
        mt = pt.matcher(vehicle);
        if (mt.matches() && vehicle.length() <= 20) this.vehicle = vehicle;
        else throw new PersonalExceptions("Строка с названием транспорта в CourierData невалидная! Она может состоять только из букв русского алфавита и не может быть больше 20 символов, причем первая буква имени должна быть прописная.");
    }
}

package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderData {

    private final Pattern ptAddress = Pattern.compile("(^([А-Я][а-я]+\\s\\d{2,},\\s)(кв\\.{1,4})$)");
    private final Pattern ptCity = Pattern.compile("(^[А-Я][а-я]{4,}$)");
    private final Pattern ptPayment = Pattern.compile("(Картой на сайте|Картой курьеру|Наличные)");

    private Matcher mt;

    private int id;
    private String address;
    private String city;
    private int courierDataId;
    private int customerDataId;
    private int floor;
    private String payment;
    private double total;

    public OrderData() {}

    public OrderData(int id, String address, String city, int courierDataId, int customerDataId, int floor, String payment, double total) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.courierDataId = courierDataId;
        this.customerDataId = customerDataId;
        this.floor = floor;
        this.payment = payment;
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", courierDataId=" + courierDataId +
                ", customerDataId=" + customerDataId +
                ", floor=" + floor +
                ", payment='" + payment + '\'' +
                ", total=" + total +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws PersonalExceptions {
        mt = ptAddress.matcher(address);
        if (mt.matches() && address.length() <= 50) this.address = address;
        else throw new PersonalExceptions("Название адреса в OrderData невалидно! Оно должно состоять из менее, чем 50 символов и включать в себя: название адреса (Притыцкого), номер дома (11), номер квартиры после запятой (кв. 11).");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws PersonalExceptions {
        mt = ptCity.matcher(city);
        if (mt.matches() && city.length() <= 20) this.city = city;
        else throw new PersonalExceptions("Название города в OrderData невалидно! Он должен включать в себя от 4 символов и более (максимально допустимое значение 20 символов).");
    }

    public int getCourierDataId() {
        return courierDataId;
    }

    public void setCourierDataId(int courierDataId) throws PersonalExceptions {
        if (courierDataId > 0) this.courierDataId = courierDataId;
        else throw new PersonalExceptions("ID курьера в OrderData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public int getCustomerDataId() {
        return customerDataId;
    }

    public void setCustomerDataId(int customerDataId) throws PersonalExceptions {
        if (customerDataId > 0) this.customerDataId = customerDataId;
        else throw new PersonalExceptions("ID пользователя в OrderData невалидный! Он не может быть отрицательным или равным нулю.");
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) throws PersonalExceptions {
        if (floor > 0 && floor <= 40) this.floor = floor;
        else throw new PersonalExceptions("Номер этажа в OrderData невалидный! Он не может быть отрицательным или равным нулю (максимально допустимое значение 40).");
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) throws PersonalExceptions {
        mt = ptPayment.matcher(payment);
        if (mt.matches() && payment.length() <= 20) this.payment = payment;
        else throw new PersonalExceptions("Название способа оплаты в OrderData невалидно! Примеры способов оплаты: 'Картой на сайте', 'Картой курьеру', 'Наличные' (максимально допустимое значение 20 символов).");
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) throws PersonalExceptions {
        if (total > 0 && total < 10000) this.total = total;
        else throw new PersonalExceptions("Итоговая стоимость заказа в OrderData невалидна! Она не может быть отрицательной, равной нулю и должна иметь два знака после запятой (максимально допустимое значение 10000).");
    }
}

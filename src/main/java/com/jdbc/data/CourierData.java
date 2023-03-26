package com.jdbc.data;

public class CourierData {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}

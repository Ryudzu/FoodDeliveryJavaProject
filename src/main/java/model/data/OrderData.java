package model.data;

@SuppressWarnings("squid:S00107")
public class OrderData {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCourierDataId() {
        return courierDataId;
    }

    public void setCourierDataId(int courierDataId) {
        this.courierDataId = courierDataId;
    }

    public int getCustomerDataId() {
        return customerDataId;
    }

    public void setCustomerDataId(int customerDataId) {
        this.customerDataId = customerDataId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

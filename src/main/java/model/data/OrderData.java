package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
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
}
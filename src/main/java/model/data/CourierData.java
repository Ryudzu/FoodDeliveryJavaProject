package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CourierData {
    private int id;
    private String courierPhone;
    private String firstname;
    private String lastname;
    private String vehicle;
}
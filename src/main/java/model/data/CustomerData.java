package model.data;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CustomerData {
    private int id;
    private String customerPhone;
    private String email;
    private String password;
    private String username;
    private Timestamp accountRegistered;
}
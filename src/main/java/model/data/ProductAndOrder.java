package model.data;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductAndOrder {
    private int amountOrdered;
    private Timestamp timeOrdered;
    private int orderDataId;
    private int productDataId;
}
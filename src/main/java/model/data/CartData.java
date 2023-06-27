package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CartData {
    private int id;
    private int amount;
    private int productDataId;
    private int customerCartId;
}
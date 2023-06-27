package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductsInCart {
    private int id;
    private String productTitle;
    private int productDataId;
    private double price;
    private int amount;
}
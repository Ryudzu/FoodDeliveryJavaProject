package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductData {
    private int id;
    private String imageLink;
    private double price;
    private int productCategoryId;
    private int productRating;
    private String productTitle;
}
package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductCategoryData {
    private int id;
    private String categoryTitle;
    private String description;
}
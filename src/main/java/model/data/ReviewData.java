package model.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ReviewData {
    private int id;
    private String comment;
    private int reviewRating;
}
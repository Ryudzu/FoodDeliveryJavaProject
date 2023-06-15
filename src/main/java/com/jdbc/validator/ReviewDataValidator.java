package com.jdbc.validator;

import com.jdbc.data.ReviewData;
import com.jdbc.exceptions.PersonalExceptions;

public final class ReviewDataValidator {

    public static final ReviewData review = new ReviewData();

    public ReviewDataValidator() {}

    public ReviewDataValidator(String comment, int reviewRating) throws PersonalExceptions {
        ValidateComment(comment);
        ValidateReviewRating(reviewRating);
    }

    public void ValidateComment(String comment) {
        review.setComment(comment);
    }

    public void ValidateReviewRating(int reviewRating) throws PersonalExceptions {
        if (reviewRating >= 1 && reviewRating < 6) review.setReviewRating(reviewRating);
        else throw new PersonalExceptions("Рейтинг отзыва в ReviewData невалидный! Он не должен быть меньше 1 и больше 5.");
    }
}

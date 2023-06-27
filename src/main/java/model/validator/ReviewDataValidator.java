package model.validator;

import model.data.ReviewData;
import model.exceptions.PersonalExceptions;

public final class ReviewDataValidator {

    public static final ReviewData review = new ReviewData();

    public ReviewDataValidator() {}

    public ReviewDataValidator(String comment, int reviewRating) throws PersonalExceptions {
        validateComment(comment);
        validateReviewRating(reviewRating);
    }

    public void validateComment(String comment) {
        review.setComment(comment);
    }

    public void validateReviewRating(int reviewRating) throws PersonalExceptions {
        if (reviewRating >= 1 && reviewRating < 6)
            review.setReviewRating(reviewRating);
        else
            throw new PersonalExceptions("Рейтинг отзыва в ReviewData невалидный! Он не должен быть меньше 1 и больше 5.");
    }
}

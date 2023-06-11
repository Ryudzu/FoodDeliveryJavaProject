package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

public class ReviewData {

    private int id;
    private String comment;
    private int reviewRating;

    public ReviewData() {}

    public ReviewData(int id, String comment, int reviewRating) {
        this.id = id;
        this.comment = comment;
        this.reviewRating = reviewRating;
    }

    @Override
    public String toString() {
        return "ReviewData{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", reviewData=" + reviewRating +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) throws PersonalExceptions {
        if (reviewRating >= 1 && reviewRating < 6) this.reviewRating = reviewRating;
        else throw new PersonalExceptions("Рейтинг отзыва в ReviewData невалидный! Он не должен быть меньше 1 и больше 5.");
    }
}

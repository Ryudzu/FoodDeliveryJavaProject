package com.jdbc.data;

import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCategoryData {

    private final Pattern ptCategoryTitle = Pattern.compile("(^([А-Я][а-я]{4,})$)");

    private int id;
    private String categoryTitle;
    private String description;

    public ProductCategoryData() {}

    public ProductCategoryData(int id, String categoryTitle, String description) {
        this.id = id;
        this.categoryTitle = categoryTitle;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductCategoryData{" +
                "id=" + id +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) throws PersonalExceptions {
        Matcher mt = ptCategoryTitle.matcher(categoryTitle);
        if (mt.matches() && categoryTitle.length() <= 30) this.categoryTitle = categoryTitle;
        else throw new PersonalExceptions("Название категории в ProductCategoryData невалидно! Она не может содержать в себе числа или быть по длинне меньше 4-х символов (максимально допустимое значение 30 символов).");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws PersonalExceptions {
        if (description.length() > 15 && description.length() <= 1000) this.description = description;
        else throw new PersonalExceptions("Описание категории в ProductCategoryData невалидно! Оно не может быть по длинне меньше 15-ти символов (максимально допустимое значение 1000 символов).");
    }
}

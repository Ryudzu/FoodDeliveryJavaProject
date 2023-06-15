package com.jdbc.validator;

import com.jdbc.data.ProductCategoryData;
import com.jdbc.exceptions.PersonalExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ProductCategoryDataValidator {

    public static final ProductCategoryData category = new ProductCategoryData();

    private final Pattern ptCategoryTitle = Pattern.compile("(^([А-Я][а-я]{4,})$)");

    public ProductCategoryDataValidator() {}

    public ProductCategoryDataValidator(String categoryTitle, String description) throws PersonalExceptions {
        ValidateCategoryTitle(categoryTitle);
        ValidateDescription(description);
    }

    public void ValidateCategoryTitle(String categoryTitle) throws PersonalExceptions {
        Matcher mt = ptCategoryTitle.matcher(categoryTitle);
        if (mt.matches() && categoryTitle.length() <= 30) category.setCategoryTitle(categoryTitle);
        else throw new PersonalExceptions("Название категории в ProductCategoryData невалидно! Она не может содержать в себе числа или быть по длинне меньше 4-х символов (максимально допустимое значение 30 символов).");
    }

    public void ValidateDescription(String description) throws PersonalExceptions {
        if (description.length() > 15 && description.length() <= 1000) category.setDescription(description);
        else throw new PersonalExceptions("Описание категории в ProductCategoryData невалидно! Оно не может быть по длинне меньше 15-ти символов (максимально допустимое значение 1000 символов).");
    }
}

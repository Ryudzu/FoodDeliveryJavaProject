package com.jdbc.data;

public class ProductCategoryData {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

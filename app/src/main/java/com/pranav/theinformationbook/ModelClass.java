package com.pranav.theinformationbook;

public class ModelClass {

    //using the name of the images we have uploaded we will show the user the relevant category image
    private String imageName;
    private String categoryName;

    //an empty constructor is not needed here as well need a category name as an input


    public String getImageName() {
        return imageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ModelClass(String imageName, String categoryName) {
        this.imageName = imageName;
        this.categoryName = categoryName;
    }
}

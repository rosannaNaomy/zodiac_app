package com.portillo.naomyportillo.zodiacappfromscratch.model;

public class ZodiacModel {

    private String name;
    private String number;
    private String image;

    public ZodiacModel(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {

        return name + " " + number + " " + image;
    }
}

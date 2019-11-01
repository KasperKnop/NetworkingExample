package com.kasperknop.networkingexample;

class Pokemon {
    private int number;
    private String name;
    private String imageUrl;

    public Pokemon(int number, String name, String imageUrl) {
        this.number = number;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

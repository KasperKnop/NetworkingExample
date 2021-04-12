package com.kasperknop.networkingexample;

class Pokemon {
    private final int number;
    private final String name;
    private final String imageUrl;

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

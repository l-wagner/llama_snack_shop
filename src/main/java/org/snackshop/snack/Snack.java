package org.snackshop.snack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snack {

    private String name = "";
    private int price = 0;
    private String storeName = "";
    private int preferenceScore = 0;

    public Snack() {
    }

    public Snack(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Snack(String name, int price, String storeName) {
        this(name, price);
        this.storeName = storeName;
    }

    public Snack(Snack snack) {
        this.name = snack.name;
        this.price = snack.price;
        this.storeName = snack.storeName;
        this.preferenceScore = snack.preferenceScore;

    }

    public Snack(Snack snack, String storeName) {
        this.name = snack.name;
        this.price = snack.price;
        this.storeName = storeName;
        this.preferenceScore = snack.preferenceScore;
    }

    public Snack(String name, int price, String storeName, int preferenceScore) {
        this.name = name;
        this.price = price;
        this.storeName = storeName;
        this.preferenceScore = preferenceScore;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPreferenceScore() {
        return preferenceScore;
    }

    public void setPreferenceScore(int preferenceScore) {
        this.preferenceScore = preferenceScore;
    }

    public String getStoreName() {
        return storeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return price == snack.price &&
                Objects.equals(name, snack.name) && Objects.equals(storeName, snack.storeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}

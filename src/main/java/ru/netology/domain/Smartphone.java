package ru.netology.domain;

public class Smartphone extends Product {
    String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || getManufacturer().equalsIgnoreCase(search);
    }
}

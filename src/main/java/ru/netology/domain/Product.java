package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor


public class Product {
    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public boolean matches(String search) {
        // ваш код
        return name.equalsIgnoreCase(search);
    }
}

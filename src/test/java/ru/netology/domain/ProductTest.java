package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    ProductRepository repositoty = new ProductRepository();
    ProductManager manager = new ProductManager(repositoty);
    private Product first = new Book(1, "Война и мир", 250, "Толстой");
    private Product second = new Smartphone(2, "samsung 10", 5600, "Samsung");
    private Product third = new Book(3, "Алхимик", 200, "Пауло Коэльо");
    private Product fourth = new Smartphone(4, "iPhone6", 11000, "Apple");
    private Product fifth = new Book(5, "Гарри Поттер", 450, "Дж. К. Роулинг");

    @BeforeEach
    void setUp() {
        manager.search(first);
        manager.search(second);
        manager.search(third);
        manager.search(fourth);
        manager.search(fifth);
    }

    @Test
    void shouldProductEquals() {
        assertTrue(second.matches("samsung 10"));
        assertTrue(third.matches("Алхимик"));
        assertTrue(fourth.matches("Apple"));
        assertTrue(fifth.matches("Дж. К. Роулинг"));
        assertTrue(first.matches("Толстой"));
    }

    @Test
    void shouldProductNotEquals() {
        assertFalse(second.matches("Самсунг"));
        assertFalse(first.matches("iPhone6"));
    }

}
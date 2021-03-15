package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Война и мир", 250, "Толстой");
    private Product second = new Smartphone(2, "samsung 10", 5600, "Samsung");
    private Product third = new Book(3, "Алхимик", 200, "Пауло Коэльо");
    private Product fourth = new Smartphone(4, "iPhone6", 11000, "Apple");
    private Product fifth = new Book(5, "Гарри Поттер", 450, "Дж. К. Роулинг");
    private Product six = new Book(6, "Книга", 200, "Пауло Коэльо");
    private Product seven = new Product(7, "Warfeic", 450);

    @BeforeEach
    void setUp() {
        manager.search(first);
        manager.search(second);
        manager.search(third);
        manager.search(fourth);
        manager.search(fifth);
        manager.search(six);
        manager.search(seven);
    }

    @Test
    void shouldSearchByBookName() {
    Product[] actual = manager.searchBy("Алхимик");
    Product[] expected = new Product[] {third};
    assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBySmartManufacture() {
        Product[] actual = manager.searchBy("Samsung");

        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookNonName() {
        Product[] actual = manager.searchBy("karen");

        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] actual = manager.searchBy("Пауло Коэльо");

        Product[] expected = new Product[]{third, six};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartName() {
        Product[] actual = manager.searchBy("iPhone6");

        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNoObject() {
        Product[] actual = manager.searchBy("Warface");

        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
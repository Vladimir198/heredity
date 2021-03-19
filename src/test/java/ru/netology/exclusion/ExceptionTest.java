package ru.netology.exclusion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Война и мир", 250, "Толстой");
    private Product second = new Smartphone(2, "samsung 10", 5600, "Samsung");
    private Product third = new Book(3, "Алхимик", 200, "Пауло Коэльо");

    @BeforeEach
    void setUp() {
        manager.search(first);
        manager.search(second);
        manager.search(third);
    }

    @Test
    void shouldRemoveByIdExist() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        assertArrayEquals(new Product[]{first, second}, repository.findAll());
    }

    @Test
    void shouldRemoveByIdNotExist() {
        int idToRemove = 5;
        assertThrows(NotFoundException.class, ()-> repository.removeById(idToRemove));
        assertArrayEquals(new Product[]{first, second, third}, repository.findAll());
    }
}

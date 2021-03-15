package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor

public class ProductManager {
    private ProductRepository repository;

    public void search(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {

        // ваш код
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result,0,tmp,0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}

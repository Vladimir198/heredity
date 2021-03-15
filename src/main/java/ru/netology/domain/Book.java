package ru.netology.domain;

public class Book extends Product {
    private String author;

    public String getAuthor() {
        return author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || getAuthor().equalsIgnoreCase(search);
    }

}

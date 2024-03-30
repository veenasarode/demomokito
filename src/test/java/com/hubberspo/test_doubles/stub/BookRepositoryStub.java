package com.hubberspo.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();

        Book book1 = new Book("1234" , "Mokito In Action" , 500 , LocalDate.now());
        Book book2 = new Book("1252" , "JUnit 5 In Action" , 400 , LocalDate.now());

        newBooks.add(book1);
        newBooks.add(book2);

        return newBooks;
    }
}

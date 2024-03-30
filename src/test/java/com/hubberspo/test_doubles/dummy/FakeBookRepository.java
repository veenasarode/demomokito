package com.hubberspo.test_doubles.dummy;

import com.hubberspo.test_doubles.dummy.Book;
import com.hubberspo.test_doubles.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    // In-memory,Hashmap,Lists

    Map<String, Book> bookStore = new HashMap<>(); //will act as lighter form of database
    @Override
    public void save(Book book) {
            bookStore.put(book.getBookId(),book);
    }



    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}

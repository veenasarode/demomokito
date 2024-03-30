package com.hubberspo.test_doubles.stub;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate , int days)
    {
         List<Book> newBook = bookRepository.findNewBooks(days);

         //for 500 apply 10% discount-> 10% of 500 is 50->500-50->450

        for (Book book : newBook)
        {
            int price = book.getPrice();
            int newPrice =  price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }
        return newBook;
    }
}

package com.hubberspo.behaviour.verification;

import com.hubberspo.behaviour.verification.BookRequest;
import com.hubberspo.behaviour.verification.Book;
import com.hubberspo.behaviour.verification.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void addBook(Book book)
    {
        if(book.getPrice() <= 500)
        {
            return;
        }
        bookRepository.save(book);
    }



    public void addBook(BookRequest bookRequest)
    {
        if(bookRequest.getPrice() <= 500)
        {
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }


}

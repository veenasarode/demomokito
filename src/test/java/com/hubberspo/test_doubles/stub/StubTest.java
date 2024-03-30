package com.hubberspo.test_doubles.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTest {

    @Test
    public void demoStub()
    {
        BookRepository bookRepository = new BookRepositoryStub();

        BookService bookService = new BookService(bookRepository);

       List<Book> newBooksWithAppliedDiscount =  bookService.getNewBooksWithAppliedDiscount(10 , 7);

       assertEquals(2 , newBooksWithAppliedDiscount.size());
       assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    public void demoStubWithMockito()
    {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BookService bookService = new BookService(bookRepository);

        Book book1 =    new Book("1234" , "Mockito In Action" , 500 , LocalDate.now());
        Book book2 = new Book("1252" , "JUnit 5 In Action" , 400 , LocalDate.now());

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount =  bookService.getNewBooksWithAppliedDiscount(10 , 7);



        assertEquals(2 , newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}

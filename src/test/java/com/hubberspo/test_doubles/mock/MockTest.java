package com.hubberspo.test_doubles.mock;

import com.hubberspo.test_doubles.mock.Book;
import com.hubberspo.test_doubles.mock.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;



public class MockTest {

    @Test
    public void demoMock()
    {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock() ;
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234" , "Mokito In Action" , 500 , LocalDate.now());

        Book book2 = new Book("1256" , "JUnit In Action" , 400 , LocalDate.now());

        bookService.addBook(book1);//return

        bookService.addBook(book2);//save will be called

        bookRepositoryMock.verify(book2 , 1);

    }

    @Test
    public void demoMockWithMockito()
    {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234" , "Mokito In Action" , 500 , LocalDate.now());

        Book book2 = new Book("1256" , "JUnit In Action" , 400 , LocalDate.now());

        bookService.addBook(book1);//return

        bookService.addBook(book2);//save will be called

       Mockito.verify(bookRepository , Mockito.times(1)).save(book2);
        Mockito.verify(bookRepository , Mockito.times(0)).save(book1);

    }
}

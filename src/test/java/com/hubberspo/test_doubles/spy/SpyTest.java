package com.hubberspo.test_doubles.spy;

import com.hubberspo.test_doubles.spy.BookRepository;
import com.hubberspo.test_doubles.spy.BookRepositorySpy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest {

    @Test
    public void demoSpy()
    {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy() ;
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234" , "Mokito In Action" , 500 , LocalDate.now());

        Book book2 = new Book("1256" , "JUnit In Action" , 400 , LocalDate.now());

        bookService.addBook(book1);
        assertEquals(0 , bookRepositorySpy.timesCalled());

        bookService.addBook(book2);
        assertEquals(1 , bookRepositorySpy.timesCalled());

        //assertTrue(bookRepositoryMock.calledWith(book2));
    }


    @Test
    public void demoSpyWithMockito()
    {
        BookRepository bookRepository = Mockito.spy(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

       Book book1 = new Book("1234" , "Mokito In Action" , 500 , LocalDate.now());

        Book book2 = new Book("1256" , "JUnit In Action" , 400 , LocalDate.now());

        bookService.addBook(book1);//return

        bookService.addBook(book2);//save will be called

        Mockito.verify(bookRepository , Mockito.times(1)).save(book2);
        Mockito.verify(bookRepository , Mockito.times(0)).save(book1);

    }
}

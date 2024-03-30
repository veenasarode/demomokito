package com.hubberspo.behaviour.verification;


import com.hubberspo.behaviour.verification.Book;
import com.hubberspo.behaviour.verification.BookRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

   @Test
    public void testAddBook()
   {
        Book book1 = new Book("1234" , "Mockito In Action" , 500 , LocalDate.now());
        bookService.addBook(book1);
        Mockito.verify(bookRepository).save(book1);
   }

    @Test
    public void testSaveBookWithBookRequest()
    {
        BookRequest bookRequest = new BookRequest("Mockito In Action" , 500 ,  LocalDate.now());

        Book book1 = new Book(null , "Mockito In Action" , 500 , LocalDate.now());

        // to deal with void method

        bookService.addBook(bookRequest);

        Mockito.verify(bookRepository).save(book1);
    }

    @Test
    public void testSaveBookMethodWithGreaterPrice()
    {
        BookRequest bookRequest = new BookRequest("Mockito In Action" , 500 ,  LocalDate.now());

        Book book = new Book(null , "Mockito In Action" , 500 , LocalDate.now());

        // to deal with void method

        bookService.addBook(bookRequest);

        Mockito.verify(bookRepository , Mockito.times(0)).save(book);
    }

    @Test
    public void testSaveBookMethodWithGreaterPrice1()
    {
        BookRequest bookRequest = new BookRequest("Mockito In Action" , 600 ,  LocalDate.now());

        Book book = new Book(null , "Mockito In Action" , 600 , LocalDate.now());

        // to deal with void method

        bookService.addBook(bookRequest);

        Mockito.verify(bookRepository , Mockito.times(1)).save(book);
    }
}

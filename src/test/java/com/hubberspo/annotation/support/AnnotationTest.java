package com.hubberspo.annotation.support;

import com.hubberspo.annotation.support.Book;
import com.hubberspo.annotation.support.BookRepository;
import com.hubberspo.annotation.support.BookService;
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

@ExtendWith(MockitoExtension.class)//telling mockito use annotations
public class AnnotationTest {

    //creating mock with annotation
    @Mock
    private BookRepository bookRepository;//class of which mock we want

    @InjectMocks
    private BookService bookService;//class under test is noted as injectmocks

    @Test
    public void demoCreateMockUsingAnnotations()
    {
       // BookRepository bookRepository = Mockito.mock(BookRepository.class);

       // BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234" , "Mockito In Action" , 500 , LocalDate.now());
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

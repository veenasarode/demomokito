package com.hubberspo.stubbing;

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

    public int calculateTotalCost(List<String> bookIds)
    {
        int total = 0;

        for (String bookId : bookIds)
        {
            Book book  = bookRepository.findBookByBookId(bookId);

                total = total + book.getPrice();
        }

        return total;
    }

    public void addBook(Book book)
    {
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

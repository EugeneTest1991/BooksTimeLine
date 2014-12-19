package com.haid.timeline.repository;

import java.util.Date;
import java.util.List;

import com.haid.timeline.domain.Book;


public interface BooksDAO {
    public abstract List<Book> getAllBooks();

    public abstract List<Book> getBooksFromPeriod(Date dateFrom, Date dateTo);

    public abstract Book getBookById(Long id);

    public abstract Long addBook(Book newBook);

    public abstract Book updateBook(Book aBook);

    public abstract void deleteBook(Long id);
}

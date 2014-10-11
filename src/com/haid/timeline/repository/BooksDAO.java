package com.haid.timeline.repository;

import java.util.Date;
import java.util.List;

import com.haid.timeline.domain.Book;


public interface BooksDAO {
    List<Book> getAllBooks();

    List<Book> getBooksFromPeriod(Date dateFrom, Date dateto);

    Book getBookById(Long id);
}

package com.haid.timeline.service;

import java.util.Date;
import java.util.List;

import com.haid.timeline.domain.Book;



public interface BookManager {

    public abstract Book getBookInfo(Long bookId);

    public abstract List<Book> getAllBooks();

    public abstract List<Book> getBooksFromPeriod(Date dateFrom, Date dateTo);

}

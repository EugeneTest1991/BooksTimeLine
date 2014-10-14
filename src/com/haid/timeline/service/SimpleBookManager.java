package com.haid.timeline.service;

import java.util.Date;
import java.util.List;

import com.haid.timeline.domain.Book;
import com.haid.timeline.repository.BooksDAO;

public class SimpleBookManager implements BookManager {

    private BooksDAO booksDAO;

    public SimpleBookManager(BooksDAO booksDAO) {
        super();
        this.booksDAO = booksDAO;
    }

    @Override
    public Book getBookInfo(Long bookId) {
        return booksDAO.getBookById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return booksDAO.getAllBooks();
    }

    @Override
    public List<Book> getBooksFromPeriod(Date dateFrom, Date dateTo) {
        return booksDAO.getBooksFromPeriod(dateFrom, dateTo);
    }

}

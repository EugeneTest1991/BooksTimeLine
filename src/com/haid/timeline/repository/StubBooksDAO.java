package com.haid.timeline.repository;

import java.util.Date;
import java.util.List;

import com.haid.timeline.domain.Book;

public class StubBooksDAO implements BooksDAO {

    private List<Book> allBooks;

    public StubBooksDAO(List<Book> books) {
        allBooks = books;
    }

    @Override
    public List<Book> getAllBooks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getBooksFromPeriod(Date dateFrom, Date dateto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}

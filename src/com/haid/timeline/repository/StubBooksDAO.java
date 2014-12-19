package com.haid.timeline.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.haid.timeline.domain.Book;

public class StubBooksDAO implements BooksDAO {

    private List<Book> allBooks;

    public StubBooksDAO(List<Book> books) {
        allBooks = new ArrayList<Book>(books);
    }

    @Override
    public List<Book> getAllBooks() {

        return new ArrayList<Book>(allBooks);
    }

    @Override
    public List<Book> getBooksFromPeriod(Date dateFrom, Date dateTo) {
        List<Book> desiredBooks = new ArrayList<Book>();
        for (Book book : allBooks) {
            if (book.getActionStart().compareTo(dateFrom) >= 0
                    && book.getActionEnd().compareTo(dateTo) <= 0) {
                desiredBooks.add(book);
            }
        }
        return desiredBooks;
    }

    @Override
    public Book getBookById(Long id) {
        Book desiredBook = null;
        for (Book book : allBooks) {
            if (id.equals(book.getId())) {
                desiredBook = book;
                break;
            }
        }
        if (desiredBook == null) {
            throw new IllegalArgumentException("No book found with such Id");
        }
        return desiredBook;
    }

    @Override
    public Long addBook(Book newBook) {
        allBooks.add(newBook);
        return newBook.getId();
    }

    @Override
    public Book updateBook(Book aBook) {
        Long id = aBook.getId();
        Book desiredBook = null;
        for (Book book : allBooks) {
            if (id.equals(book.getId())) {
                desiredBook = book;
                break;
            }
        }
        if (desiredBook == null) {
            throw new IllegalArgumentException(
                    "No book found with such Id for update");
        }
        desiredBook.setAuthor(aBook.getAuthor());
        desiredBook.setTitle(aBook.getTitle());
        desiredBook.setActionStart(aBook.getActionStart());
        desiredBook.setActionEnd(aBook.getActionEnd());
        return desiredBook;
    }

    @Override
    public void deleteBook(Long id) {
        int index = 0;
        for (Book book : allBooks) {
            if (id.equals(book.getId())) {
                break;
            }
            index++;
        }
        allBooks.remove(index);
    }

}

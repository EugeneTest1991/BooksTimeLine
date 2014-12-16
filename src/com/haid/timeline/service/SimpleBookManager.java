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
    public BookDTO getBookInfo(Long bookId) {
        Book desiredBook = booksDAO.getBookById(bookId);
        return BookTransformer.generateDTO(desiredBook);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = booksDAO.getAllBooks();
        return BookTransformer.generateDTOList(allBooks);
    }

    @Override
    public List<BookDTO> getBooksFromPeriod(Date dateFrom, Date dateTo) {
        List<Book> booksFromPeriod =
                booksDAO.getBooksFromPeriod(dateFrom, dateTo);
        return BookTransformer.generateDTOList(booksFromPeriod);
    }

    @Override
    public Long addBook(BookDTO bookDTO) {
        Book newBook = BookTransformer.generateEntity(bookDTO);
        Long bookId = booksDAO.addBook(newBook);
        return bookId;
    }

}

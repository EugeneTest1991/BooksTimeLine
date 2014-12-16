package com.haid.timeline.service;

import java.util.Date;
import java.util.List;

public interface BookManager {

    public abstract BookDTO getBookInfo(Long bookId);

    public abstract List<BookDTO> getAllBooks();

    public abstract List<BookDTO> getBooksFromPeriod(Date dateFrom, Date dateTo);

    public abstract Long addBook(BookDTO bookDTO);

    public abstract BookDTO updateBook(BookDTO bookDTO);
}

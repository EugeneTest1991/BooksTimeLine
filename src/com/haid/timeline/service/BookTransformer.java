package com.haid.timeline.service;

import java.util.ArrayList;
import java.util.List;

import com.haid.timeline.domain.Book;

public final class BookTransformer {

    public static List<BookDTO> generateDTOList(List<Book> books) {
        List<BookDTO> booksDTO = new ArrayList<BookDTO>(books.size());
        for (Book book : books) {
            booksDTO.add(generateDTO(book));
        }
        return booksDTO;
    }

    public static BookDTO generateDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setActionStart(book.getActionStart());
        bookDTO.setActionEnd(book.getActionEnd());
        return bookDTO;
    }

    public static Book generateEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setActionStart(bookDTO.getActionStart());
        book.setActionEnd(bookDTO.getActionEnd());
        return book;
    }
}

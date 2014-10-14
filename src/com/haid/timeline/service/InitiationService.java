package com.haid.timeline.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.haid.timeline.domain.Book;
import com.haid.timeline.repository.BooksDAO;
import com.haid.timeline.repository.StubBooksDAO;

public class InitiationService {

    public static BookManager initBookManager() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            Book toKilltheBird =
                    new Book(1L, "‎Harper Lee", "To Kill a Mockingbird", sdf.parse("01/1/1935"),
                            sdf.parse("01/1/1936"));
            Book uncleToms =
                    new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin",
                            sdf.parse("01/1/1850"), sdf.parse("01/1/1852"));

            List<Book> allBooks = new ArrayList<Book>();
            allBooks.add(uncleToms);
            allBooks.add(toKilltheBird);

            BooksDAO booksDAO = new StubBooksDAO(allBooks);
            BookManager manager = new SimpleBookManager(booksDAO);
            return manager;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

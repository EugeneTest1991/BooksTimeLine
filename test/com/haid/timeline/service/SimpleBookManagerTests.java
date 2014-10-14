package com.haid.timeline.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haid.timeline.domain.Book;
import com.haid.timeline.repository.StubBooksDAO;

public class SimpleBookManagerTests {

    private SimpleBookManager manager;
    private StubBooksDAO booksDAO;

    private Book toKilltheBird;
    private Book uncleToms;

    List<Book> allBooks;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        toKilltheBird =
                new Book(1L, "‎Harper Lee", "To Kill a Mockingbird", sdf.parse("01/1/1935"),
                        sdf.parse("01/1/1936"));
        uncleToms =
                new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin", sdf.parse("01/1/1850"),
                        sdf.parse("01/1/1852"));

        allBooks = new ArrayList<Book>();
        allBooks.add(uncleToms);
        allBooks.add(toKilltheBird);

        booksDAO = new StubBooksDAO(allBooks);
        manager = new SimpleBookManager(booksDAO);
    }

    @Test
    public void testGetBookInfo() {
        long idOfMockingBird = toKilltheBird.getId();
        Book returnedBook = manager.getBookInfo(idOfMockingBird);
        assertEquals("not return MockinBird", toKilltheBird, returnedBook);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> returnedBooks = manager.getAllBooks();
        assertEquals("wrong size", allBooks.size(), returnedBooks.size());
        assertTrue("not contain MockinBird", returnedBooks.contains(toKilltheBird));
        assertTrue("not contain UncleTom", returnedBooks.contains(uncleToms));
    }

    @Test
    public void testGetBooksFromPeriod() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

        List<Book> returnedBooks;
        try {
            returnedBooks =
                    manager.getBooksFromPeriod(sdf.parse("01/1/1900"), sdf.parse("01/1/1950"));
            assertEquals("wrong size", 1, returnedBooks.size());
            assertTrue("not contain MockinBird", returnedBooks.contains(toKilltheBird));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }


    }

}

package com.haid.timeline.repository;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haid.timeline.domain.Book;

public class StubBooksDAOTests {

    private StubBooksDAO booksDAO;

    private Book toKilltheBird;
    private Book uncleTom;

    List<Book> allBooks;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        toKilltheBird =
                new Book(1L, "‎Harper Lee", "To Kill a Mockingbird", sdf.parse("01/1/1935"),
                        sdf.parse("01/1/1936"));
        uncleTom =
                new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin", sdf.parse("01/1/1850"),
                        sdf.parse("01/1/1852"));
        allBooks = new ArrayList<Book>();
        allBooks.add(uncleTom);
        allBooks.add(toKilltheBird);

        booksDAO = new StubBooksDAO(allBooks);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> returnedBooks = booksDAO.getAllBooks();
        assertEquals("wrong size", allBooks.size(), returnedBooks.size());
        assertTrue("not contain MockinBird", returnedBooks.contains(toKilltheBird));
        assertTrue("not contain UncleTom", returnedBooks.contains(uncleTom));
    }

    @Test
    public void testGetBooksFromPeriod() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetBookById() {
        fail("Not yet implemented");
    }

}

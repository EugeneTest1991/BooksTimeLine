package com.haid.timeline.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haid.timeline.domain.Book;

public class StubBooksDAOTests {

    private StubBooksDAO booksDAO;

    private Book toKilltheBird;
    private Book uncleToms;
    private Book financier;

    List<Book> allBooks;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        toKilltheBird =
                new Book(1L, "‎Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        uncleToms =
                new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin",
                        sdf.parse("01/1/1850"), sdf.parse("01/1/1852"));
        financier =
                new Book(3L, "Theodore Dreiser", "The Financier",
                        sdf.parse("01/1/1860"), sdf.parse("01/1/1870"));

        allBooks = new ArrayList<Book>();
        allBooks.add(uncleToms);
        allBooks.add(toKilltheBird);

        booksDAO = new StubBooksDAO(allBooks);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> returnedBooks = booksDAO.getAllBooks();
        assertEquals("wrong size", allBooks.size(), returnedBooks.size());
        assertTrue("not contain MockinBird",
                returnedBooks.contains(toKilltheBird));
        assertTrue("not contain UncleTom", returnedBooks.contains(uncleToms));
    }

    @Test
    public void testGetBookById() {
        long idOfMockingBird = toKilltheBird.getId();
        Book returnedBook = booksDAO.getBookById(idOfMockingBird);
        assertEquals("not return MockinBird", toKilltheBird, returnedBook);

        long idOfUncleTom = uncleToms.getId();
        returnedBook = booksDAO.getBookById(idOfUncleTom);
        assertEquals("not return UncleToms", uncleToms, returnedBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBookByIdOfNotExistedBook() {
        long idOfNotExistedBook = 0L;
        booksDAO.getBookById(idOfNotExistedBook);
    }

    @Test
    public void testGetBooksFromPeriod() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            List<Book> returnedBooks =
                    booksDAO.getBooksFromPeriod(sdf.parse("01/1/1850"),
                            sdf.parse("01/1/1900"));
            assertEquals("wrong size", 1, returnedBooks.size());
            assertTrue("not contain UncleTom",
                    returnedBooks.contains(uncleToms));

            returnedBooks =
                    booksDAO.getBooksFromPeriod(sdf.parse("01/1/1750"),
                            sdf.parse("01/1/1852"));
            assertEquals("wrong size", 1, returnedBooks.size());
            assertTrue("not contain UncleTom",
                    returnedBooks.contains(uncleToms));

            returnedBooks =
                    booksDAO.getBooksFromPeriod(sdf.parse("01/1/1900"),
                            sdf.parse("01/1/1950"));
            assertEquals("wrong size", 1, returnedBooks.size());
            assertTrue("not contain MockinBird",
                    returnedBooks.contains(toKilltheBird));

            returnedBooks =
                    booksDAO.getBooksFromPeriod(sdf.parse("01/1/1800"),
                            sdf.parse("01/1/1950"));
            assertEquals("wrong size", 2, returnedBooks.size());
            assertTrue("not contain UncleTom",
                    returnedBooks.contains(uncleToms));
            assertTrue("not contain MockinBird",
                    returnedBooks.contains(toKilltheBird));

            returnedBooks =
                    booksDAO.getBooksFromPeriod(sdf.parse("01/1/1900"),
                            sdf.parse("01/1/1900"));
            assertEquals("wrong size", 0, returnedBooks.size());
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAddBook() {
        Long id = booksDAO.addBook(financier);
        Book returnedBook = booksDAO.getBookById(id);
        assertEquals("not return Financier", financier, returnedBook);
    }

    @Test
    public void testUpdateBook() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Book toKilltheBird =
                new Book(1L, "‎Nelle Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        Book returnedBook = booksDAO.updateBook(toKilltheBird);
        assertEquals("not return MockinBird with updated value", toKilltheBird,
                returnedBook);
        Book returnedBookById = booksDAO.getBookById(toKilltheBird.getId());
        assertEquals("return another MockinBird by id", returnedBookById,
                returnedBook);
    }

    @Test
    public void testDeleteBook() {
        long idOfMockingBird = toKilltheBird.getId();
        booksDAO.deleteBook(idOfMockingBird);
        assertTrue("not delete MockinBird",
                !(booksDAO.getAllBooks().contains(toKilltheBird)));
    }

}

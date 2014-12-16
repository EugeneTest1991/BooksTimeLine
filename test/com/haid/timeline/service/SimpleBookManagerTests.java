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
    private Book toKilltheBirdBook;
    private Book uncleTomsBook;
    private Book financier;
    List<Book> allBooks;

    private BookDTO toKilltheBirdDTO;
    private BookDTO uncleTomsDTO;
    private BookDTO financierDTO;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        toKilltheBirdBook =
                new Book(1L, "‎Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        uncleTomsBook =
                new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin",
                        sdf.parse("01/1/1850"), sdf.parse("01/1/1852"));
        financier =
                new Book(3L, "Theodore Dreiser", "The Financier",
                        sdf.parse("01/1/1860"), sdf.parse("01/1/1870"));

        allBooks = new ArrayList<Book>();
        allBooks.add(uncleTomsBook);
        allBooks.add(toKilltheBirdBook);

        manager = new SimpleBookManager(new StubBooksDAO(allBooks));

        toKilltheBirdDTO =
                new BookDTO(1L, "‎Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        uncleTomsDTO =
                new BookDTO(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin",
                        sdf.parse("01/1/1850"), sdf.parse("01/1/1852"));
        financierDTO =
                new BookDTO(3L, "Theodore Dreiser", "The Financier",
                        sdf.parse("01/1/1860"), sdf.parse("01/1/1870"));
    }

    @Test
    public void testGetBookInfo() {
        long idOfMockingBird = toKilltheBirdBook.getId();
        BookDTO generatedDTO = manager.getBookInfo(idOfMockingBird);
        assertEquals("not return MockinBirdDTO", toKilltheBirdDTO, generatedDTO);
    }

    @Test
    public void testGetAllBooks() {
        List<BookDTO> returnedBooksDTO = manager.getAllBooks();
        assertEquals("wrong size", allBooks.size(), returnedBooksDTO.size());
        assertTrue("not contain MockinBirdDTO",
                returnedBooksDTO.contains(toKilltheBirdDTO));
        assertTrue("not contain UncleTomDTO",
                returnedBooksDTO.contains(uncleTomsDTO));
    }

    @Test
    public void testGetBooksFromPeriod() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

        List<BookDTO> returnedBooksDTO;
        try {
            returnedBooksDTO =
                    manager.getBooksFromPeriod(sdf.parse("01/1/1900"),
                            sdf.parse("01/1/1950"));
            assertEquals("wrong size", 1, returnedBooksDTO.size());
            assertTrue("not contain MockinBirdDTO",
                    returnedBooksDTO.contains(toKilltheBirdDTO));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testAddBook() {
        Long id = manager.addBook(financierDTO);
        BookDTO returnedBookDTO = manager.getBookInfo(id);
        assertEquals("not return FinancierDTO", financierDTO, returnedBookDTO);
    }

    @Test
    public void testUpdateBook() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        BookDTO toKilltheBirdDTO =
                new BookDTO(1L, "‎Nelle Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        BookDTO returnedBookDTO = manager.updateBook(toKilltheBirdDTO);
        assertEquals("not return MockinBirdDTO with updated value",
                toKilltheBirdDTO, returnedBookDTO);
        BookDTO returnedBookDTOById =
                manager.getBookInfo(toKilltheBirdDTO.getId());
        assertEquals("return another MockinBird by id", returnedBookDTOById,
                returnedBookDTO);
    }

}

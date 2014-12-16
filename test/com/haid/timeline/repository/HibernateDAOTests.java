package com.haid.timeline.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.haid.timeline.domain.Book;

public class HibernateDAOTests {

    private HibernateDAO hibernateDAO = new HibernateDAO();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {


    }

    @Test
    public void testGetAllBooks() {
        System.out.println(hibernateDAO.getAllBooks());
    }

    @Test
    public void tastGetBookById() {
        System.out.println(hibernateDAO.getBookById(1L));
    }

    @Test
    public void testGetBooksFromPeriod() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        System.out.println(hibernateDAO.getBooksFromPeriod(
                sdf.parse("01/1/1800"), sdf.parse("01/1/1901")));

    }

    @Test
    public void tastAddBook() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Book financier =
                new Book(null, "Theodore Dreiser", "The Financier",
                        sdf.parse("01/1/1860"), sdf.parse("01/1/1870"));
        Long bookId = hibernateDAO.addBook(financier);
        System.out.println(bookId);
        System.out.println("after add " + hibernateDAO.getBookById(bookId));
    }

    @Test
    public void tastUpdateBook() throws ParseException {
        Book book = hibernateDAO.getBookById(1L);
        book.setTitle("new title");
        Book updatedBook = hibernateDAO.updateBook(book);
        System.out.println(updatedBook);
        assertEquals("not return updated book", book, updatedBook);
    }
}

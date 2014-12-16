package com.haid.timeline.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.haid.timeline.domain.Book;

public class HibernateDAOTests {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {


    }

    @Test
    public void testGetAllBooks() {
        System.out.println(new HibernateDAO().getAllBooks());
    }

    @Test
    public void tastGetBookById() {
        System.out.println(new HibernateDAO().getBookById(1L));
    }

    @Test
    public void testGetBooksFromPeriod() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        System.out.println(new HibernateDAO().getBooksFromPeriod(
                sdf.parse("01/1/1800"), sdf.parse("01/1/1901")));

    }

    @Test
    public void tastAddBook() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Book financier =
                new Book(null, "Theodore Dreiser", "The Financier",
                        sdf.parse("01/1/1860"), sdf.parse("01/1/1870"));
        Long bookId = new HibernateDAO().addBook(financier);
        System.out.println(bookId);
        System.out.println("after add "
                + new HibernateDAO().getBookById(bookId));
    }

}

package com.haid.timeline.repository;

import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haid.timeline.domain.Book;

public class StubBooksDAOTests {

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Book toKilltheBird =
                new Book(1L, "‎Harper Lee", "To Kill a Mockingbird", sdf.parse("01/1/1935"),
                        sdf.parse("01/1/1936"));
        Book uncleTom =
                new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin", sdf.parse("01/1/1850"),
                        sdf.parse("01/1/1852"));
        List<Book> books = new ArrayList<Book>();
        books.add(uncleTom);
        books.add(toKilltheBird);
    }

    @Test
    public void testGetAllBooks() {
        fail("Not yet implemented");
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

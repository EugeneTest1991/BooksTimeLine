package com.haid.timeline.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateDAOTests {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {


    }

    @Test
    public void testGetAllBooks() {
        System.err.println(new HibernateDAO().getAllBooks());
    }

    @Test
    public void tastGetBookById() {
        System.err.println(new HibernateDAO().getBookById(1L));
    }

    @Test
    public void testGetBooksFromPeriod() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

        try {
            System.err.println(new HibernateDAO().getBooksFromPeriod(sdf.parse("01/1/1800"),
                    sdf.parse("01/1/1901")));
        } catch (ParseException e) {
            e.printStackTrace();
            org.junit.Assert.fail();
        }
    }

}

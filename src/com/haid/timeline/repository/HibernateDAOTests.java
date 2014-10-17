package com.haid.timeline.repository;

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

}

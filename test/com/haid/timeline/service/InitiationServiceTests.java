package com.haid.timeline.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InitiationServiceTests {

    @Before
    public void setUp() throws Exception {}

    @Test
    public final void testInitBookManager() {
        BookManager bookManager = InitiationService.initBookManager();
        assertNotNull("not init BookManager", bookManager);
        assertNotNull("not init books collection", bookManager.getAllBooks());
        assertNotEquals("empty books collection", 0L, bookManager.getAllBooks()
                .size());
    }

}

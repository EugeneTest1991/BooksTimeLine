package com.haid.timeline.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haid.timeline.domain.Book;

public class BookTransformerTests {

    private Book toKilltheBirdBook;
    private Book uncleTomsBook;
    List<Book> allBooks;

    private BookDTO toKilltheBirdDTO;
    private BookDTO uncleTomsDTO;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        toKilltheBirdBook =
                new Book(1L, "‎Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        uncleTomsBook =
                new Book(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin",
                        sdf.parse("01/1/1850"), sdf.parse("01/1/1852"));

        allBooks = new ArrayList<Book>();
        allBooks.add(uncleTomsBook);
        allBooks.add(toKilltheBirdBook);

        toKilltheBirdDTO =
                new BookDTO(1L, "‎Harper Lee", "To Kill a Mockingbird",
                        sdf.parse("01/1/1935"), sdf.parse("01/1/1936"));
        uncleTomsDTO =
                new BookDTO(2L, "Harriet Beecher Stowe", "Uncle Tom's Cabin",
                        sdf.parse("01/1/1850"), sdf.parse("01/1/1852"));
    }

    @Test
    public void testGenerateDTO() {
        BookDTO generatedDTO = BookTransformer.generateDTO(toKilltheBirdBook);
        assertEquals(toKilltheBirdDTO, generatedDTO);
    }

    @Test
    public void testGenerateEntity() {
        Book generatedBook = BookTransformer.generateEntity(uncleTomsDTO);
        assertEquals(uncleTomsBook, generatedBook);
    }

    @Test
    public void testGenerateDTOList() {
        List<BookDTO> generatedBooksDTO =
                BookTransformer.generateDTOList(allBooks);
        assertEquals(allBooks.size(), generatedBooksDTO.size());
        assertTrue("not contain MockinBirdDTO",
                generatedBooksDTO.contains(toKilltheBirdDTO));
        assertTrue("not contain UncleTomDTO",
                generatedBooksDTO.contains(uncleTomsDTO));
    }

}

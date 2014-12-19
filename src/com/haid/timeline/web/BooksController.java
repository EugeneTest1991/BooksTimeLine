package com.haid.timeline.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.haid.timeline.service.BookDTO;
import com.haid.timeline.service.BookManager;

@Controller
public class BooksController {
    private BookManager bookManager;

    @Autowired
    public BooksController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @RequestMapping("/")
    public String showBooksPage(Model model) {
        model.addAttribute("books", bookManager.getAllBooks());
        return "info";
    }

    @RequestMapping({"/time"})
    public String showTime(Model model) {
        return "timeglider";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<BookDTO> showBooksjson() {
        return bookManager.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public BookDTO showBookjson(@PathVariable("id") Long bookId) {
        return bookManager.getBookInfo(bookId);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        bookManager.addBook(bookDTO);
        return bookManager.getAllBooks();
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
        bookManager.updateBook(bookDTO);
        return bookManager.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE,
            produces = "application/json")
    @ResponseBody
    public List<BookDTO> deleteBook(@PathVariable("id") Long bookId) {
        bookManager.deleteBook(bookId);
        return bookManager.getAllBooks();
    }
}

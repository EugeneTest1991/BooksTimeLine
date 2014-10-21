package com.haid.timeline.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haid.timeline.domain.Book;
import com.haid.timeline.service.BookManager;

@Controller
public class BooksController {
    private BookManager bookManager;

    @Autowired
    public BooksController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @RequestMapping({"/", "/books"})
    public String showBooksPage(Model model) {
        model.addAttribute("books", bookManager.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/jsons", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<Book> showBooksjson() {
        return bookManager.getAllBooks();
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public @ResponseBody Book showBookjson() {
        return new Book();
    }

}

package com.haid.timeline.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

package com.haid.timeline.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haid.timeline.domain.Book;
import com.haid.timeline.service.BookManager;

public class BooksServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // private static final String COMMAND = "command";

    private BookManager bookManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {

        List<Book> books = bookManager.getAllBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/books.jsp");
        dispatcher.forward(request, response);
        // response.sendRedirect("/jsp/books.jsp");

        // String commandString = request.getParameter(COMMAND);
        // if (commandString != null && !commandString.isEmpty()) {
        // response.setContentType("text/html");
        // // Command command = CommandFactory.getCommand(commandString);
        // // command.execute(request, response);
        // } else {
        // // String page = PropertyReader.getString(URL_BUNDLE, ERROR_PAGE_KEY);
        // String page = null;
        // response.sendRedirect(page);
        // }
    }

    @Override
    public void init() throws ServletException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context-config.xml");
        bookManager = (BookManager) context.getBean("bookManager");
    }



}

package com.haid.timeline.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.haid.timeline.domain.Book;

public class HibernateDAO implements BooksDAO {

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    private static final SessionFactory sessionFactory;

    @Override
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Book> books = session.createQuery("FROM Book").list();
        session.close();
        return books;
    }

    @Override
    public List<Book> getBooksFromPeriod(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}

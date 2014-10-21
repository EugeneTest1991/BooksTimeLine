package com.haid.timeline.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.haid.timeline.domain.Book;

public class HibernateDAO implements BooksDAO {

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
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
        Session session = sessionFactory.openSession();
        Query query =
                session.createQuery("FROM Book WHERE actionStart >= :dateFrom AND actionEnd <= :dateTo");
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateTo);
        @SuppressWarnings("unchecked")
        List<Book> books = query.list();
        session.close();
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        Session session = sessionFactory.openSession();
        Book book = (Book) session.load(Book.class, id);
        session.close();
        return book;

    }

}

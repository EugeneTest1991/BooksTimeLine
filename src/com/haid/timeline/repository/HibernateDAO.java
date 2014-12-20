package com.haid.timeline.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.*;
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
        Book book = (Book) session.get(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public Long addBook(Book newBook) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(newBook);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return newBook.getId();
    }

    @Override
    public Book updateBook(Book aBook) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.merge(aBook);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return aBook;
    }

    @Override
    public void deleteBook(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            Query query = session.createQuery("DELETE Book WHERE id = :bookId");
            query.setParameter("bookId", id);
            int result = query.executeUpdate();
            if (result == 1) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
    }

}

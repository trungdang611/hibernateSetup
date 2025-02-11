package com.example.dao;

import com.example.dto.BookCountDTO;
import com.example.entity.Author;
import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public Book save(Book book) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(book);
            tx.commit();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Save book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Save book success!");
            }
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(book);
            tx.commit();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("update book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("update book success!");
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Book book) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(book);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("delete book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("delete book success!");
            }
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Book book = session.get(Book.class, id);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find book success!");
            }
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Book";
            Query<Book> books = session.createQuery(hql);
            return books.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find all book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find all book success!");
            }
        }
        return null;
    }

//    query
    @Override
    public List<Book> findAllBookByName(String name) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // HQL
            String hql = "FROM Book where bookTitle like :name";
            Query<Book> query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find all book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find all book success!");
            }
        }

        return null;
    }

    @Override
    public List<Book> findAllBookByAuthorName(String authorName) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // HQL
            String hql = "select b from Book b join b.author a where a.authorName=:name";
            Query<Book> query = session.createQuery(hql);
            query.setParameter("name", "%" + authorName + "%");

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find all book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find all book success!");
            }
        }

        return null;
    }

    @Override
    public List<Book> findAllBookByYear(int year) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // HQL
            String hql = "FROM Book where YEAR(publishedDate) = :year";
            Query<Book> query = session.createQuery(hql);
            query.setParameter("year", year );

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find all book error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find all book success!");
            }
        }

        return null;
    }

    @Override
    public List<BookCountDTO> findBookCountByAuthor() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = """
                    select new com.example.dto.BookCountDTO(a.authorName, count(b.bookId))
                    from Author a
                    left JOIN Book b ON a.authorId = b.author.authorId
                    group by a.id
                    """;

            Query query = session.createQuery(hql, BookCountDTO.class);

            return (List<BookCountDTO>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<BookCountDTO> findTotalQuantityBooksByAuthor() {
        return List.of();
    }

    @Override
    public long findTotalQuantityBooksByAuthorId(int authorId) {
        return 0;
    }

    @Override
    public List<Book> findBooksWithZeroPriceOrZeroQuantity() {
        return List.of();
    }

    @Override
    public List<Book> findBooksByPriceRange(double minPrice, double maxPrice) {
        return List.of();
    }

    @Override
    public List<Author> findTop3AuthorsWithMostBooks() {
        return List.of();
    }
}

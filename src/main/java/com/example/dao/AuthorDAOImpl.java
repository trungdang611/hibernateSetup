package com.example.dao;

import com.example.entity.Author;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public Author save(Author author) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(author);
            tx.commit();
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Save author error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("Save author success!");
            }
        }
        return null;
    }

    @Override
    public Author update(Author author) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(author);
            tx.commit();
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("update author error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("update author success!");
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Author author) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(author);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("delete author error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("delete author success!");
            }
        }
        return false;
    }

    @Override
    public Author findById(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Author author = session.get(Author.class, id);
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find author error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find author success!");
            }
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Author";
            Query<Author> authors = session.createQuery(hql);
            return authors.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("find all author error!");
        } finally {
            if (session != null) {
                session.close();
                System.out.println("find all author success!");
            }
        }
        return null;
    }
}

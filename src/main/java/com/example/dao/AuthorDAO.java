package com.example.dao;


import com.example.entity.Author;

import java.util.List;

public interface AuthorDAO {
    Author save(Author book);

    Author update (Author book);

    Boolean delete(Author book);

    Author findById(int id);

    List<Author> findAll();

}

package se.lexicon.jpa_workshop.Dao;

import se.lexicon.jpa_workshop.Entity.Author;

import java.util.Collection;

public interface AuthorDao {
    Author findById(int id);

    Collection<Author> findAll();

    Author create(Author author);

    Author update(Author author);

    void delete(int id);



}

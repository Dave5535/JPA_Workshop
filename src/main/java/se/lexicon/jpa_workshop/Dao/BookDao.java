package se.lexicon.jpa_workshop.Dao;

import se.lexicon.jpa_workshop.Entity.Book;

import java.util.Collection;

public interface BookDao {
    Book findById(int id);

    Collection<Book> findAll();

    Book create(Book book);

    Book update(Book book);

    void delete(int id);
}

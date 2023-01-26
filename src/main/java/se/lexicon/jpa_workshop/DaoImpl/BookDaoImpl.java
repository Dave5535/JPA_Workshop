package se.lexicon.jpa_workshop.DaoImpl;

import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.Dao.BookDao;
import se.lexicon.jpa_workshop.Entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
@Repository
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class,id);
    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("select s from Book s").getResultList();
    }

    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(int id) {

        Book book = entityManager.find(Book.class,id);
        entityManager.remove(book);
    }
}

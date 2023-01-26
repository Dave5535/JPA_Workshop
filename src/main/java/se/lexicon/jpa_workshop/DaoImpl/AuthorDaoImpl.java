package se.lexicon.jpa_workshop.DaoImpl;

import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.Dao.AuthorDao;
import se.lexicon.jpa_workshop.Entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("select s from Author s").getResultList();
    }

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    public void delete(int id) {
        Author author = entityManager.find(Author.class, id);

        entityManager.remove(author);
    }
}

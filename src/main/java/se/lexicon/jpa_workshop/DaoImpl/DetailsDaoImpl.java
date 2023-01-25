package se.lexicon.jpa_workshop.DaoImpl;

import se.lexicon.jpa_workshop.Dao.DetailsDao;
import se.lexicon.jpa_workshop.Entity.Details;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.Exception.DataInsufficient;
import se.lexicon.jpa_workshop.Exception.DataWasNotFound;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DetailsDaoImpl implements DetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("select s from Details s").getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) throws DataInsufficient {
        if (details == null) throw new DataInsufficient("Data was null");
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) throws DataInsufficient {
        if (details == null) throw new DataInsufficient("Data was null");
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(int id) throws DataWasNotFound {
        Details details = entityManager.find(Details.class, id);
        if (details == null) throw new DataWasNotFound("Id do not exist");
        entityManager.remove(details);
    }
}

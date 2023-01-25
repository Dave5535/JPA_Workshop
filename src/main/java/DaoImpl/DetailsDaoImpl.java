package DaoImpl;

import Dao.DetailsDao;
import Entity.Details;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        return entityManager.find(Details.class,id);
    }
@Transactional(readOnly = true)
    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("select s from Details s").getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(int id) {
entityManager.remove(entityManager.find(Details.class,id));
    }
}

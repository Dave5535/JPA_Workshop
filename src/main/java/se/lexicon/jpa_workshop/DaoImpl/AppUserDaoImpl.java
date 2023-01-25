package se.lexicon.jpa_workshop.DaoImpl;

import se.lexicon.jpa_workshop.Dao.AppUserDao;
import se.lexicon.jpa_workshop.Entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.Exception.DataInsufficient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
@Repository
public class AppUserDaoImpl implements AppUserDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class,id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("select s from AppUser s").getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) throws DataInsufficient {
        if (appUser == null) throw new DataInsufficient("Data was null");
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) throws DataInsufficient {
        if (appUser == null) throw new DataInsufficient("Data was null");
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(int id) throws DataInsufficient {
        AppUser appUser =entityManager.find(AppUser.class,id);
        if (appUser == null) throw new DataInsufficient("Data was null");
        entityManager.remove(appUser);
    }
}

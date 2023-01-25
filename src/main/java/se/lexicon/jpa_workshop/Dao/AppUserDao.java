package se.lexicon.jpa_workshop.Dao;

import se.lexicon.jpa_workshop.Entity.AppUser;
import se.lexicon.jpa_workshop.Exception.DataInsufficient;

import java.util.Collection;

public interface AppUserDao {

    AppUser findById(int id);

    Collection<AppUser> findAll();

    AppUser create(AppUser appUser) throws DataInsufficient;

    AppUser update(AppUser appUser) throws DataInsufficient;

    void delete(int id) throws DataInsufficient;
}

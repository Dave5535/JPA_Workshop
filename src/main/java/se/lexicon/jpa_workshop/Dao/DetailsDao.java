package se.lexicon.jpa_workshop.Dao;

import se.lexicon.jpa_workshop.Entity.Details;
import se.lexicon.jpa_workshop.Exception.DataInsufficient;
import se.lexicon.jpa_workshop.Exception.DataWasNotFound;

import java.util.Collection;

public interface DetailsDao {

    Details findById(int id);
    Collection<Details> findAll();

    Details create(Details details) throws DataInsufficient;

    Details update(Details details) throws DataInsufficient;

    void delete(int id) throws DataWasNotFound;
}

package se.lexicon.jpa_workshop.Dao;

import se.lexicon.jpa_workshop.Entity.BookLoan;

import java.util.Collection;

public interface BookLoanDao {
    BookLoan findById(int id);

    Collection<BookLoan> findAll();

    BookLoan create(BookLoan bookLoan);

    BookLoan update(BookLoan bookLoan);

    void delete(int id);
}

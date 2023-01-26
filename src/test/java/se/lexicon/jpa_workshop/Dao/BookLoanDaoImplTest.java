package se.lexicon.jpa_workshop.Dao;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.Entity.AppUser;
import se.lexicon.jpa_workshop.Entity.Book;
import se.lexicon.jpa_workshop.Entity.BookLoan;
import se.lexicon.jpa_workshop.Entity.Details;

import java.time.LocalDate;


@SpringBootTest
@AutoConfigureTestDatabase       // use the test database not the original
@Transactional
@AutoConfigureTestEntityManager   // uses a test EntityManager
@DirtiesContext
public class BookLoanDaoImplTest {

    @Autowired
    TestEntityManager em;

    @Autowired
    BookLoanDao testObject;

int createdAppUser1;
    public void setup() {


    }
@Test
    public void persist() {
Details details = new Details("testemail","testname",LocalDate.parse("2002-04-12"));
    Book bookData = new Book("Book For Testing",30);
    AppUser appUserData = new AppUser("Test","PasswordTesting",details);

    BookLoan bookLoanData =new BookLoan(LocalDate.now().plusDays(bookData.getMaxLoanDays()));
        BookLoan createdBookLoanData = testObject.create(bookLoanData);
    createdBookLoanData.borrowBook(bookData);
    createdBookLoanData.setAppUser(appUserData);

assertNotNull(createdBookLoanData);
    }
}

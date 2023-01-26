package se.lexicon.jpa_workshop;

import se.lexicon.jpa_workshop.Dao.*;
import se.lexicon.jpa_workshop.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.Exception.DataInsufficient;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    BookLoanDao bookLoanDao;

    @Autowired
    AuthorDao authorDao;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
creatBook_Author();
       // create_AppUser_Details_Book_BookLoan();
    }

    public void create_AppUser_Details() {
        System.out.println("########################");

        try {
            AppUser createdappUser = appUserDao.create(new AppUser(
                    "test",
                    "testPassword", new Details("Email.com", "Name", LocalDate.parse("2001-01-01"))));

        } catch (DataInsufficient e) {
            System.out.println(e.getMessage());
        }
        try {
            AppUser createdappUser = appUserDao.create(new AppUser(
                    "Object",
                    "testPassword"));
        } catch (DataInsufficient e) {
            System.out.println(e.getMessage());
        }
        System.out.println("########################");
    }
    public void create_AppUser_Details_Book_BookLoan() {
        System.out.println("########################");

        try {
            AppUser createdappUser = appUserDao.create(new AppUser(
                    "test",
                    "testPassword", new Details("Email.com", "Name", LocalDate.parse("2001-01-01"))));

            Book createdtestbook = bookDao.create(new Book("Titel", 30));
            BookLoan createdBookLoan = bookLoanDao.create(new BookLoan(LocalDate.now().plusDays(createdtestbook.getMaxLoanDays())));

            createdBookLoan.borrowBook(createdtestbook);
            createdBookLoan.setAppUser(createdappUser);

        } catch (DataInsufficient e) {
            System.out.println(e.getMessage());
        }
        System.out.println("########################");
    }
    public void creatBook_Author(){
        Book createdtestbook = bookDao.create(new Book("Book", 30));
        BookLoan createdBookLoan = bookLoanDao.create(new BookLoan(LocalDate.now().plusDays(createdtestbook.getMaxLoanDays())));
        Book createdTestBook2 = bookDao.create(new Book("Book", 50));
        BookLoan createdBookLoan2 = bookLoanDao.create(new BookLoan(LocalDate.now().plusDays(createdTestBook2.getMaxLoanDays())));

        Author createdAuthor = authorDao.create(new Author("AuthorFirstName","AuthorLastName"));

        createdAuthor.addBook(createdtestbook);
    }


}

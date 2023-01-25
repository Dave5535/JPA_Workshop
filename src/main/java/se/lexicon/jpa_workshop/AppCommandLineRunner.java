package se.lexicon.jpa_workshop;

import se.lexicon.jpa_workshop.Dao.AppUserDao;
import se.lexicon.jpa_workshop.Dao.DetailsDao;
import se.lexicon.jpa_workshop.Entity.AppUser;
import se.lexicon.jpa_workshop.Entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.Exception.DataInsufficient;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner{
    @Autowired
    AppUserDao appUserDao;
    @Autowired
    DetailsDao detailsDao;

        @Override
        @Transactional
        public void run(String... args) throws Exception {

            create_AppUser_Details();
        }
        public void create_AppUser_Details(){
                System.out.println("########################");
            try {
                appUserDao.create(new AppUser(
                        "test",
                        "testPassword",
                        new Details("testEmail@test","TestName", LocalDate.parse("2001-01-01"))));
            } catch (DataInsufficient e) {
                System.out.println(e.getMessage());;
            }
            System.out.println("########################");
        }
}

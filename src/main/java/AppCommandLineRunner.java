

import Dao.AppUserDao;
import Dao.DetailsDao;
import Entity.AppUser;
import Entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

            ex1();
        }
        public void ex1(){
                System.out.println("########################");
appUserDao.create(new AppUser(
        "test",
        "testPassword",
        new Details("testEmail@test","TestName", LocalDate.parse("2001-01-01"))));
                System.out.println("########################");
        }
}

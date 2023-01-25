package se.lexicon.jpa_workshop.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;
    @Column(nullable = false,length = 120,unique = true)
    private String email;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false)
    private LocalDate birthday;
    @OneToOne(mappedBy = "details")
    private AppUser appUser;

    public Details() {
    }

    public Details(String email, String name, LocalDate birthday) {
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public Details(int detailsId, String email, String name, LocalDate birthday, AppUser appUser) {
        this.detailsId = detailsId;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.appUser = appUser;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return detailsId == details.detailsId && Objects.equals(email, details.email) && Objects.equals(name, details.name) && Objects.equals(birthday, details.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, email, name, birthday);
    }

    @Override
    public String toString() {
        return "Details{" +
                "detailsId=" + detailsId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

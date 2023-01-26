package se.lexicon.jpa_workshop.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int appUserId;
    @Column(nullable = false,length = 100,unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(updatable = false)
    private LocalDate regDate;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "details_id")
    private Details details;

    @OneToMany(mappedBy = "appUser")
    private List<BookLoan> loans;


    public AppUser() {
    }

    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.regDate = LocalDate.now();

    }

    public AppUser(String userName, String password, Details details) {
        this.userName = userName;
        this.password = password;
        this.regDate = LocalDate.now();

        setDetails(details);
    }

    public AppUser(int appUserId, String userName, String password, Details details) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.password = password;

        setDetails(details);
    }

public void addBookLoan(BookLoan bookLoan){
  if (bookLoan == null) throw new IllegalArgumentException("data was null");
  if (loans == null) loans = new ArrayList<>();
  loans.add(bookLoan);
  bookLoan.setAppUser(this);


}
public void removeBookLoan(BookLoan bookLoan){
    if (bookLoan == null) throw new IllegalArgumentException("data was null");
    if (loans == null) loans = new ArrayList<>();
        loans.remove(bookLoan);
        bookLoan.removeLoan(bookLoan);

}





    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
       if (password.length() > 7) throw new IllegalArgumentException("Password should be 8 character or longer! ");
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
       if (details != null) details.setAppUser(this);
        this.details = details;
    }

    public List<BookLoan> getLoans() {
        if (loans == null) loans = new ArrayList<>();
        return loans;
    }

    public void setLoans(List<BookLoan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && Objects.equals(userName, appUser.userName) && Objects.equals(regDate, appUser.regDate) && Objects.equals(details, appUser.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, userName, regDate, details);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", regDate=" + regDate +
                ", details=" + details +
                '}';
    }
}

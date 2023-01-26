package se.lexicon.jpa_workshop.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    @Column(nullable = false)
    private LocalDate loanDate;
    @Column(nullable = false)
    private LocalDate dueDate;
    @Column
    private boolean returned;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "details_id")
    private AppUser appUser;
    @ManyToOne(cascade ={CascadeType.REFRESH,CascadeType.DETACH } )
    @JoinColumn(name = "BookLoans_Id")
    private Book book;

    public BookLoan() {
    }

    public BookLoan(LocalDate dueDate) {
        this.loanDate = LocalDate.now();
        this.dueDate = dueDate;
        this.returned = false;
    }


public void removeLoan(BookLoan bookLoan){
if (book == null) throw new IllegalArgumentException("bookLoan was null");
appUser.getLoans().remove(this);


}

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
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
        BookLoan bookLoan = (BookLoan) o;
        return loanId == bookLoan.loanId && returned == bookLoan.returned && Objects.equals(loanDate, bookLoan.loanDate) && Objects.equals(dueDate, bookLoan.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanDate, dueDate, returned);
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                '}';
    }
}

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

    @OneToMany(mappedBy = "borrowedBooks",orphanRemoval = true)
    private List<AppUser> appUsers;
    @OneToMany(mappedBy = "borrower",orphanRemoval = true)
    private List<Book> books;

    public BookLoan() {
    }

    public BookLoan(LocalDate dueDate) {
        this.loanDate = LocalDate.now();
        this.dueDate = dueDate;
        this.returned = false;
    }

    public void borrowBook(Book book)  {
        if (book == null) throw new IllegalArgumentException("Book data was null");
        if (books == null) books = new ArrayList<>();
        books.add(book);
        book.setBorrower(this);

    }
public void setAppUser(AppUser appUser) {
        if (appUser == null) throw  new IllegalArgumentException("AppUserData was null");
        if (appUsers == null) books = new ArrayList<>();
        appUser.setBorrowedBooks(this);


}
public void overemphasise(AppUser appUser){


}

    public void returnBook(Book book)  {
        if (book == null) throw new IllegalArgumentException("Book data was null");
        if (books != null){
            book.setBorrower(null);
            books.remove(book);
            this.returned = true;
        }
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

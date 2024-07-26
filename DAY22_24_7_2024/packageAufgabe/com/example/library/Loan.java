package DAY22_24_7_2024.packageAufgabe.com.example.library;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    List<Book> loanBookList;

    public Loan() {
        this.loanBookList = new ArrayList<>();
    }

    public List<Book> getLoanBookList() {
        return loanBookList;
    }

    public void setLoanBookList(List<Book> loanBookList) {
        this.loanBookList = loanBookList;
    }

    public void addLoanBookList(Book book) {
        this.loanBookList.add(book);
    }

    public void removeLoanBookList(Book book) {
        this.loanBookList.remove(book);
    }

}

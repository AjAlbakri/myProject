package daos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import daos.LoanDAO;
import models.Loan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoanDAOTest {

    private static LoanDAO loanDAO;

    @BeforeAll
    static void setUp() {
        loanDAO = new LoanDAO();
    }

    @Test
    void returnBookWithValidLoanId() {
        // Assuming you have a loan with a valid loanId in the database
        int validLoanId = 1;

        boolean success = loanDAO.returnBook(validLoanId);

        assertTrue(success, "Returning a book with a valid loanId should pass");
    }

    @Test
    void returnBookWithInvalidLoanId() {
        // Assuming you have a loan with an invalid loanId in the database
        int invalidLoanId = -1;

        boolean success = loanDAO.returnBook(invalidLoanId);

        assertFalse(success, "Returning a book with an invalid loanId should fail");
    }

    @Test
    void borrowBookWithValidLoan() {
        // Create a valid Loan object
        Loan validLoan = new Loan(1, 2, LocalDate.now(), LocalDate.now().plusDays(7));

        boolean success = loanDAO.borrowBook(validLoan);

        assertTrue(success, "Borrowing a book with a valid Loan object should pass");
    }

    @Test
    void borrowBookWithInvalidLoan() {
        // Create an invalid Loan object with negative member and book IDs
        Loan invalidLoan = new Loan(-1, -2, LocalDate.now(), LocalDate.now().plusDays(7));

        boolean success = loanDAO.borrowBook(invalidLoan);

        assertFalse(success, "Borrowing a book with an invalid Loan object should fail");
    }

    @Test
    void getAllLoans() {
        List<Loan> loans = loanDAO.getAllLoans();

        assertNotNull(loans, "Getting all loans should not return null");
        assertTrue(loans.size() > 0, "Getting all loans should return a non-empty list");
    }

}


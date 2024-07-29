package daos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import daos.FineDAO;
import models.Fine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FineDAOTest {

    private static FineDAO fineDAO;

    @BeforeAll
    static void setUp() {
        fineDAO = new FineDAO();
    }

    @Test
    void addFineWithValidFine() {
        // Create a valid Fine object
        Fine validFine = new Fine(1, 100.0, "Late Return", LocalDate.now(), null);

        boolean success = fineDAO.addFine(validFine);

        assertTrue(success, "Adding a fine with valid data should pass");
    }

    @Test
    void addFineWithInvalidFine() {

        Fine invalidFine = new Fine(1, -50.0, "Invalid Fine", LocalDate.now(), null);

        boolean success = fineDAO.addFine(invalidFine);

        assertFalse(success, "Adding a fine with invalid data should fail");
    }

    @Test
    void deleteFineWithValidFineID() {

        int validFineID = 1;

        boolean success = fineDAO.deleteFine(validFineID);

        assertTrue(success, "Deleting a fine with a valid FineID should pass");
    }

    @Test
    void deleteFineWithInvalidFineID() {

        int invalidFineID = -1;

        boolean success = fineDAO.deleteFine(invalidFineID);

        assertFalse(success, "Deleting a fine with an invalid FineID should fail");
    }

    @Test
    void fetchAllFines() {
        List<Fine> fines = fineDAO.fetchAllFines();

        assertNotNull(fines, "Fetching all fines should not return null");
    }

    // Additional test methods for other CRUD operations can be added here.
}

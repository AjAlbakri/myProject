package controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import models.Loan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class ReturnBookDialogControllerTest extends ApplicationTest {

    private ReturnBookDialogController controller;

    @BeforeEach
    public void setUp() throws Exception {
        // Set up your TestFX environment here
        // This typically involves loading the FXML file for the ReturnBookDialog and initializing the controller
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Clean up the TestFX environment after tests
        FxToolkit.hideStage();
    }

    @Test
    public void testFieldsPopulatedCorrectly() {
        // Create a mock Loan object
        Loan mockLoan = new Loan(/* initialize with test data */);

        // Call controller.setSelectedLoan with the mock Loan
        controller.setSelectedLoan(mockLoan);

        // Verify that fields are populated correctly
        verifyThat("#loanIdField", hasText(String.valueOf(mockLoan.getLoanId())));
        verifyThat("#memberIdField", hasText(String.valueOf(mockLoan.getMemberId())));
        // Add checks for other fields...
    }

    @Test
    public void testHandleConfirmReturn() {
        // You need to mock the behavior of the LoanDAO and any other external dependencies
        // Simulate clicking the confirm button and verify the expected behaviors

        // Example:
        clickOn("#confirmButton");
        // Verify that the LoanDAO's returnBook method is called, etc.
    }

    // Additional test cases as needed...
}

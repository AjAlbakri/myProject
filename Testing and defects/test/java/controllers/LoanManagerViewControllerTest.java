package controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TableViewMatchers.*;

public class LoanManagerViewControllerTest extends ApplicationTest {

    private LoanManagerViewController controller;

    @BeforeEach
    public void setUp() throws Exception {
        // Set up your TestFX environment here
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Clean up the TestFX environment after tests
        FxToolkit.hideStage();
    }

    @Test
    public void testLoanTableViewPopulated() {
        // Your test code here
    }

    @Test
    public void testAnotherFunctionality() {
        // Another test method here
    }

    // Additional test methods, each annotated with @Test
}

package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import java.net.URL;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class BookAddDialogControllerTest extends ApplicationTest {

    private BookAddDialogController controller;

    @Override
    public void start(Stage stage) throws Exception {
        // The path to the FXML file should be relative to the src/main/resources directory
        URL fxmlLocation = getClass().getResource("/views/AddBookDialog.fxml");
        if (fxmlLocation == null) {
            throw new IllegalStateException("Cannot find FXML file at /views/BookAddDialog.fxml");
        }
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent mainNode = loader.load();
        controller = loader.getController();
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }





    @Test
    public void shouldCreateBookWhenValidInput() {
        // Simulate user inputs
        clickOn("#titleField").write("Test Title");
        clickOn("#authorFirstNameField").write("JUAN");
        clickOn("#authorSurnameField").write("Cena");
        clickOn("#isbnField").write("1234567890");
        DatePicker publishDatePicker = lookup("#publishDateField").query();
        publishDatePicker.setValue(LocalDate.of(2020, 1, 1));
        clickOn("#genreField").write("Fiction");
        clickOn("#publisherNameField").write("Test Publisher");
        clickOn("#availabilityStatusField").write("Available");
        clickOn("#conditionField").write("New");

        // Simulate clicking the save button
        clickOn("Save");

        // Assertions
        assertTrue(controller.isOkClicked());
        assertNotNull(controller.getNewBook());
        assertEquals("Test Title", controller.getNewBook().getTitle());
        // Additional assertions for other fields...
    }

    @Test
    public void shouldShowErrorWhenInvalidInput() {
        // Simulate invalid user inputs and clicking save
        clickOn("#titleField").write("");
        clickOn("#saveButton");

        // Verify that error messages are displayed
        // This part of the test will depend on how your application displays error messages
        // Assert that newBook is not created or is in the correct state
        assertFalse(controller.isOkClicked());
        assertNull(controller.getNewBook());
    }

    // Additional test cases as needed


        // ... existing code ...

        @Test
        public void shouldShowErrorWhenPartiallyInvalidInput() {
            clickOn("#titleField").write("Valid Title");
            clickOn("#authorFirstNameField").write(""); // Invalid input
            clickOn("#authorSurnameField").write("Muk");
            clickOn("#isbnField").write("1234567890");
            DatePicker publishDatePicker = lookup("#publishDateField").query();
            publishDatePicker.setValue(LocalDate.of(2020, 1, 1));
            clickOn("#genreField").write("Fiction");
            clickOn("#publisherNameField").write("Test Publisher");
            clickOn("#availabilityStatusField").write("Available");
            clickOn("#conditionField").write("New");
            clickOn("#saveButton");

            assertFalse(controller.isOkClicked());
            assertNull(controller.getNewBook());
        }

        @Test
        public void shouldShowErrorWhenEmptyFields() {
            clickOn("#saveButton");

            assertFalse(controller.isOkClicked());
            assertNull(controller.getNewBook());
        }

        @Test
        public void shouldShowErrorForInvalidISBN() {
            clickOn("#titleField").write("Test Title");
            clickOn("#authorFirstNameField").write("AJ");
            clickOn("#authorSurnameField").write("Muk");
            clickOn("#isbnField").write("123"); // Invalid ISBN
            // ... rest of the fields ...
            clickOn("#saveButton");

            assertFalse(controller.isOkClicked());
            assertNull(controller.getNewBook());
        }

        @Test
        public void shouldShowErrorForFuturePublishDate() {
            clickOn("#titleField").write("Test Title");
            // ... rest of the fields ...
            DatePicker publishDatePicker = lookup("#publishDateField").query();
            publishDatePicker.setValue(LocalDate.now().plusDays(1)); // Future date
            clickOn("#saveButton");

            assertFalse(controller.isOkClicked());
            assertNull(controller.getNewBook());
        }

        // ... any additional test cases ...
    }



package daos;

import models.Book;
import org.junit.jupiter.api.*;
//import some.package.BookManager; // Make sure the package path is correct


import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;






class BookDAOTest {

    private BookDAO bookDAO;
    private Book testBook;

    @BeforeEach
    void setUp() {
        bookDAO = new BookDAO();
        testBook = new Book(1, "Test Title", "Author First Name",
                "Author Surname", "1234567890", LocalDate.now(), "Genre",
                "Publisher Name", "Available", "New Condition");
    }

    @AfterEach
    void tearDown() {
        // Add any necessary teardown code here
    }

    @Test
    void addBook() {
        assertTrue(bookDAO.addBook(testBook));
    }

    @Test
    void updateBookAvailabilityStatus() {
        bookDAO.addBook(testBook);
        assertTrue(bookDAO.updateBookAvailabilityStatus(testBook.getBookID(), "New Status"));
    }

    @Test
    void getBook() {
        bookDAO.addBook(testBook);
        Book retrievedBook = bookDAO.getBook(testBook.getBookID());
        assertNotNull(retrievedBook);
    }

    @Test
    void getAllBooks() {
        bookDAO.addBook(testBook);
        List<Book> books = bookDAO.getAllBooks();
        assertFalse(books.isEmpty());
    }

    @Test
    void updateBook() {
        bookDAO.addBook(testBook);
        testBook.setTitle("Updated Title");
        assertTrue(bookDAO.updateBook(testBook));
    }

    @Test
    void deleteBook() {
        bookDAO.addBook(testBook);
        assertTrue(bookDAO.deleteBook(testBook.getBookID()));
    }


    @Test
    void addBookWithEmptyTitle() {
        Book bookToAdd = new Book(1, "", "Author First Name",
                "Author Surname", "1234567890", LocalDate.now(),
                "Genre", "Publisher Name", "Available", "New Condition");
        boolean isBookAdded = bookDAO.addBook(bookToAdd);
        assertFalse(isBookAdded, "Book with an empty title should not be added successfully");
    }


    @Test
    void addBookWithLowercaseTitle() {
        Book bookToAdd = new Book(1, "a lowercase title", "Author First Name",
                "Author Surname", "1234567890", LocalDate.now(),
                "Genre", "Publisher Name", "Available", "New Condition");
        boolean isBookAdded = bookDAO.addBook(bookToAdd);
        assertTrue(isBookAdded, "Book with a lowercase title should be added successfully");
    }

    // Additional tests for other title conditions...

    @Test
    void addBookWithTitleContainingSpecialCharacters() {
        Book bookToAdd = new Book(1, "Invalid@Title!", "Author First Name",
                "Author Surname", "1234567890", LocalDate.now(),
                "Genre", "Publisher Name", "Available", "New Condition");
        boolean isBookAdded = bookDAO.addBook(bookToAdd);
        assertFalse(isBookAdded, "Book with a title containing special characters should not be added successfully");
    }

    @Test
    void addBookWithTitleContainingNumbers() {
        Book bookToAdd = new Book(1, "Title123", "Author First Name",
                "Author Surname", "1234567890", LocalDate.now(),
                "Genre", "Publisher Name", "Available", "New Condition");
        boolean isBookAdded = bookDAO.addBook(bookToAdd);
        assertFalse(isBookAdded, "Book with a title containing numbers should not be added successfully");
    }

    // authors first name


    @Test
    void addBookWithExtendedLengthFirstName() {
        Book book = new Book(1, "The Chronicles of Long Names", "ThisIsAnExtremelyLongFirstNameThatExceedsNormalLengths", "Author Surname", "1234567890", LocalDate.now(), "Fantasy", "Epic Publications", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with extended length first name should be added successfully");
    }

    @Test
    void addBookWithLowercaseFirstName() {
        Book book = new Book(1, "Whispers of the Forest", "lowercase", "Author Surname", "1234567890", LocalDate.now(), "Mystery", "Nature Press", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with lowercase first name should be added successfully");
    }

    @Test
    void addBookWithUppercaseFirstName() {
        Book book = new Book(1, "Echoes in the Canyon", "UPPERCASE", "Author Surname", "1234567890", LocalDate.now(), "Adventure", "Grand Canyon Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with uppercase first name should be added successfully");
    }

    @Test
    void addBookWithMixedCaseFirstName() {
        Book book = new Book(1, "Melodies of Life", "MixedCase", "Author Surname", "1234567890", LocalDate.now(), "Biography", "Harmony Books", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with mixed case first name should be added successfully");
    }

    @Test
    void addBookWithFirstNameContainingApostrophe() {
        Book book = new Book(1, "O'Malley's Adventure", "O'Malley", "Author Surname", "1234567890", LocalDate.now(), "Travel", "Explorer's Journal", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with first name containing an apostrophe should be added successfully");
    }

    @Test
    void addBookWithFirstNameContainingHyphens() {
        Book book = new Book(1, "The Tale of Anne-Marie", "Anne-Marie", "Author Surname", "1234567890", LocalDate.now(), "Historical Fiction", "Past Times Publications", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with first name containing hyphens should be added successfully");
    }


    @Test
    void addBookWithFirstNameContainingSpecialCharacters() {
        Book book = new Book(1, "Mystery of the Symbols", "!@#$%", "Author Surname", "1234567890", LocalDate.now(), "Thriller", "Cipher Publishing", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with first name containing special characters should not be added successfully");
    }

    @Test
    void addBookWithFirstNameContainingNumbers() {
        Book book = new Book(1, "Numbers Game", "John123", "Author Surname", "1234567890", LocalDate.now(), "Science Fiction", "Futuristic Press", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with first name containing numbers should not be added successfully");
    }

    @Test
    void addBookWithEmptyFirstName() {
        Book book = new Book(1, "The Unnamed Hero", "", "Author Surname", "1234567890", LocalDate.now(), "Drama", "Anonymous Writers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with an empty first name should not be added successfully");
    }

    @Test
    void addBookWithFirstNameContainingSpecialCharactersAndNumbers() {
        Book book = new Book(1, "Encoded Messages", "Jane@123", "Author Surname", "1234567890", LocalDate.now(), "Mystery", "Enigma Publications", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with first name containing special characters and numbers should not be added successfully");
    }


    // surname

    @Test
    void addBookWithExtendedLengthSurname() {
        Book book = new Book(1, "Title", "Author First Name", "ExtremelyLongSurnameThatExceedsNormalLengths", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book));
    }

    @Test
    void addBookWithLowercaseSurname() {
        Book book = new Book(1, "Title", "Author First Name", "lowercase", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book));
    }

    @Test
    void addBookWithUppercaseSurname() {
        Book book = new Book(1, "Title", "Author First Name", "UPPERCASE", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book));
    }

    @Test
    void addBookWithMixedCaseSurname() {
        Book book = new Book(1, "Title", "Author First Name", "MixedCase", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book));
    }

    @Test
    void addBookWithSurnameContainingApostrophe() {
        Book book = new Book(1, "Title", "Author First Name", "O'Malley", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book));
    }

    @Test
    void addBookWithSurnameContainingHyphens() {
        Book book = new Book(1, "Title", "Author First Name", "Anne-Marie", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book));
    }

    @Test
    void addBookWithSurnameContainingSpecialCharacters() {
        Book book = new Book(1, "Title", "Author First Name", "!@#$%", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book));
    }

    @Test
    void addBookWithSurnameContainingNumbers() {
        Book book = new Book(1, "Title", "Author First Name", "Surname123", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book));
    }

    @Test
    void addBookWithEmptySurname() {
        Book book = new Book(1, "Title", "Author First Name", "", "1234567890", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book));
    }
    // ISBN


    @Test
    void addBookWithValidISBN() {
        Book book = new Book(1, "Valid ISBN Book", "Author First Name", "Author Surname", "1234567890123", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with a valid ISBN should be added");
    }

    @Test
    void addBookWithISBNContainingHyphens() {
        Book book = new Book(1, "Hyphenated ISBN Book", "Author First Name", "Author Surname", "123-456-789-0123", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with an ISBN containing hyphens should be added");
    }

    @Test
    void addBookWithISBNContainingWords() {
        Book book = new Book(1, "Wordy ISBN Book", "Author First Name", "Author Surname", "ISBNWithWords", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with an ISBN containing words should not be added");
    }

    @Test
    void addBookWithISBNContainingWordsAndNumbers() {
        Book book = new Book(1, "Alphanumeric ISBN Book", "Author First Name", "Author Surname", "ISBN123456", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with an ISBN containing words and numbers should not be added");
    }

    @Test
    void addBookWithISBNContainingSpecialCharacters() {
        Book book = new Book(1, "Special Character ISBN Book", "Author First Name", "Author Surname", "123!@#456$%^789", LocalDate.now(), "Genre", "Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with an ISBN containing special characters should not be added");
    }
    // date


    @Test
    void addBookWithValidPublishDate() {
        Book book = new Book(1, "A Tale of Time", "Author First Name", "Author Surname", "1234567890", LocalDate.now().minusYears(1), "Genre", "Timeless Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with a valid publish date should be added");
    }

    @Test
    void addBookWithFuturePublishDate() {
        Book book = new Book(1, "Future Chronicles", "Author First Name", "Author Surname", "1234567890", LocalDate.now().plusYears(1), "Genre", "Futuristic Press", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with a future publish date should not be added");
    }
    //Genre


    @Test
    void addBookWithValidGenre() {
        Book book = new Book(1, "Classic Genre", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with a valid genre should be added");
    }

    @Test
    void addBookWithGenreContainingHyphens() {
        Book book = new Book(1, "Hyphenated Genre", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Sci-Fi-Fantasy", "Hyphen Press", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with a genre containing hyphens should not be added");
    }

    @Test
    void addBookWithGenreContainingCombinations() {
        Book book = new Book(1, "Combined Genre", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Thriller-Adventure123", "Combo Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with a genre containing combinations of words, numbers, and hyphens should not be added");
    }

    @Test
    void addBookWithGenreContainingSpecialCharacters() {
        Book book = new Book(1, "Special Character Genre", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Mystery!@#", "Unique Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with a genre containing special characters should not be added");
    }

    @Test
    void addBookWithEmptyGenre() {
        Book book = new Book(1, "Empty Genre", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "", "Blank Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with an empty genre should not be added");
    }

    @Test
    void addBookWithDuplicateGenre() {
        Book book1 = new Book(1, "First Genre", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "UniqueGenre", "Original Publishers", "Available", "New Condition");
        bookDAO.addBook(book1);
        Book book2 = new Book(2, "Duplicate Genre", "Author First Name", "Author Surname", "0987654321", LocalDate.now(), "UniqueGenre", "Copycat Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book2), "Book with a duplicate genre should not be added");
    }
    //publisher name


    @Test
    void addBookWithExtendedLengthPublisherName() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "ExtremelyLongPublisherNameThatExceedsNormalLengths", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with extended length publisher name should be");

    }

    @Test
    void addBookWithPublisherNameContainingSpaces() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Space Filled Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with publisher name containing spaces should be added successfully");
    }

    @Test
    void addBookWithPublisherNameContainingHyphens() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Hyphen-Publisher-Name", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with publisher name containing hyphens should be added successfully");
    }

    @Test
    void addBookWithUppercasePublisherName() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "UPPERCASE PUBLISHER", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with uppercase publisher name should be added successfully");
    }

    @Test
    void addBookWithLowercasePublisherName() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "lowercase publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with lowercase publisher name should be added successfully");
    }

    @Test
    void addBookWithMixedCasePublisherName() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "MixedCase Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with mixed case publisher name should be added successfully");
    }

    @Test
    void addBookWithDuplicatePublisherName() {
        Book book1 = new Book(1, "Title One", "Author", "Surname", "ISBN1", LocalDate.now(), "Genre", "Unique Publisher", "Available", "New Condition");
        bookDAO.addBook(book1);
        Book book2 = new Book(2, "Title Two", "Author", "Surname", "ISBN2", LocalDate.now(), "Genre", "Unique Publisher", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book2), "Book with a duplicate publisher name should be added successfully");
    }

    @Test
    void addBookWithPublisherNameContainingSpecialCharacters() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Special!@# Publisher", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with publisher name containing special characters should not be added successfully");
    }

    @Test
    void addBookWithEmptyPublisherName() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book");


    }
    //conditions


    @Test
    void addBookWithSingleCondition() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Single Condition", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with a single valid condition should be added successfully");
    }

    @Test
    void addBookWithValidConditions() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Valid, Multiple, Conditions", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with valid multiple conditions should be added successfully");
    }

    @Test
    void addBookWithMultipleConditions() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Condition 1, Condition 2", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with multiple valid conditions should be added successfully");
    }

    @Test
    void addBookWithEmptyConditions() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with empty conditions should not be added successfully");
    }

    @Test
    void addBookWithConditionContainingSpecialCharacters() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Special!@# Condition", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with conditions containing special characters should not be added successfully");
    }

    @Test
    void addBookWithConditionContainingNumeric() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Condition with 123", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with conditions containing numeric should not be added successfully");
    }
    //Availability


    @Test
    void addBookWithValidAvailability() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Valid Availability", "New Condition");
        assertTrue(bookDAO.addBook(book), "Book with valid availability should be added successfully");
    }

    @Test
    void addBookWithEmptyAvailability() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with empty availability should not be added successfully");
    }

    @Test
    void addBookWithInvalidAvailability() {
        Book book = new Book(1, "Title", "Author", "Surname", "ISBN", LocalDate.now(), "Genre", "Publisher", "Invalid Availability", "New Condition");
        assertFalse(bookDAO.addBook(book), "Book with invalid availability should not be added successfully");
    }

    // Book manager EDIT


    @Test
    void addBookEditTitleWithValidTitle() {
        Book book = new Book(1, "Valid Title", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit title with a valid title should be added");
    }

    @Test
    void addBookEditTitleWithUppercaseTitle() {
        Book book = new Book(1, "UPPERCASE TITLE", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit title with an uppercase title should be added");
    }

    @Test
    void addBookEditTitleWithLowercaseTitle() {
        Book book = new Book(1, "lowercase title", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit title with a lowercase title should be added");
    }

    @Test
    void addBookEditTitleWithMixedCaseTitle() {
        Book book = new Book(1, "MiXeD CaSe TiTlE", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit title with a mixed-case title should be added");
    }

    @Test
    void addBookEditTitleWithAlphanumericTitle() {
        Book book = new Book(1, "Title123", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit title with an alphanumeric title should be added");
    }

    @Test
    void addBookEditTitleWithSpecialCharacterTitle() {
        Book book = new Book(1, "Special@Title", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit title with a special character in the title should not be added");
    }

    @Test
    void addBookEditTitleWithHyphenAndSpecialCharacterTitle() {
        Book book = new Book(1, "Hyphen-&-Special", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit title with hyphen and special character in the title should not be added");
    }

    @Test
    void addBookEditTitleWithSpecialCharacterAndAlphanumericTitle() {
        Book book = new Book(1, "Special123@Title", "Author First Name", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit title with special character and alphanumeric in the title should not be added");
    }

    // edit first name
    @Test
    void addBookEditFirstNameWithValidFirstName() {
        Book book = new Book(1, "Valid Title", "John", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit first name with a valid first name should be added");
    }

    @Test
    void addBookEditFirstNameWithMixedCaseFirstName() {
        Book book = new Book(1, "Valid Title", "JoHn", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit first name with a mixed-case first name should be added");
    }

    @Test
    void addBookEditFirstNameWithUppercaseFirstName() {
        Book book = new Book(1, "Valid Title", "JOHN", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit first name with an uppercase first name should be added");
    }

    @Test
    void addBookEditFirstNameWithLowercaseFirstName() {
        Book book = new Book(1, "Valid Title", "john", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit first name with a lowercase first name should be added");
    }

    @Test
    void addBookEditFirstNameWithHyphenFirstName() {
        Book book = new Book(1, "Valid Title", "John-Smith", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit first name with a hyphen in the first name should be added");
    }

    @Test
    void addBookEditFirstNameWithFirstNameContainingHyphenAndNumericCharacters() {
        Book book = new Book(1, "Valid Title", "Jo-Hn123", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit first name with hyphen and numeric characters in the first name should be added");
    }

    @Test
    void addBookEditFirstNameWithMixedCaseHyphenAndSpecialCharactersInFirstName() {
        Book book = new Book(1, "Valid Title", "Joh#n-Smith", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit first name with mixed-case, hyphen, and special characters in the first name should not be added");
    }

    @Test
    void addBookEditFirstNameWithSpecialCharactersInFirstName() {
        Book book = new Book(1, "Valid Title", "@uthor", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit first name with special characters in the first name should not be added");
    }

    @Test
    void addBookEditFirstNameWithEmptyFirstName() {
        Book book = new Book(1, "Valid Title", "", "Author Surname", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit first name with an empty first name should not be added");
    }
// second name

    @Test
    void addBookEditSurnameWithValidSurname() {
        Book book = new Book(1, "Valid Title", "John", "Smith", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit surname with a valid surname should be added");
    }

    @Test
    void addBookEditSurnameWithMixedCaseSurname() {
        Book book = new Book(1, "Valid Title", "John", "SmItH", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit surname with a mixed-case surname should be added");
    }

    @Test
    void addBookEditSurnameWithUppercaseSurname() {
        Book book = new Book(1, "Valid Title", "John", "SMITH", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit surname with an uppercase surname should be added");
    }

    @Test
    void addBookEditSurnameWithLowercaseSurname() {
        Book book = new Book(1, "Valid Title", "John", "smith", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit surname with a lowercase surname should be added");
    }

    @Test
    void addBookEditSurnameWithHyphenSurname() {
        Book book = new Book(1, "Valid Title", "John", "Smith-Jones", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit surname with a hyphen in the surname should be added");
    }

    @Test
    void addBookEditSurnameWithSurnameContainingHyphenAndNumericCharacters() {
        Book book = new Book(1, "Valid Title", "John", "Smith123", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit surname with hyphen and numeric characters in the surname should be added");
    }

    @Test
    void addBookEditSurnameWithMixedCaseHyphenAndSpecialCharactersInSurname() {
        Book book = new Book(1, "Valid Title", "John", "Sm!th-Jones", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit surname with mixed-case, hyphen, and special characters in the surname should not be added");
    }

    @Test
    void addBookEditSurnameWithSpecialCharactersInSurname() {
        Book book = new Book(1, "Valid Title", "AJ", "SOMALI", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit surname with special characters in the surname should not be added");
    }

    @Test
    void addBookEditSurnameWithEmptySurname() {
        Book book = new Book(1, "Valid Title", "Joh", "", "1234567890", LocalDate.now(), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit surname with an empty surname should not be added");
    }
// ISBN
@Test
void addBookEditISBNWithValidISBNDifferentName() {
    Book book = new Book(1, "Valid Title", "Alice", "Johnson", "1234567890", LocalDate.of(2023, 5, 10), "Fiction", "Standard Publishers", "Available", "New Condition");
    assertTrue(bookDAO.addBook(book), "addBook edit ISBN with a valid ISBN should be added");
}

    @Test
    void addBookEditISBNWithHyphensInISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "Bob", "Williams", "12-345-67890", LocalDate.of(2023, 6, 15), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit ISBN with hyphens in ISBN should be added");
    }

    @Test
    void addBookEditISBNWithAlphabeticCharactersInISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "Charlie", "Davis", "ABCD123456", LocalDate.of(2023, 7, 20), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit ISBN with alphabetic characters in ISBN should not be added");
    }

    @Test
    void addBookEditISBNWithUppercaseCharactersInISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "David", "Miller", "1234X567890", LocalDate.of(2023, 8, 25), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit ISBN with uppercase characters in ISBN should not be added");
    }

    @Test
    void addBookEditISBNWithLowercaseCharactersInISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "Eva", "Brown", "1234x567890", LocalDate.of(2023, 9, 30), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit ISBN with lowercase characters in ISBN should not be added");
    }

    @Test
    void addBookEditISBNWithAlphanumericCharactersInISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "Frank", "Smith", "12A34B567890", LocalDate.of(2023, 10, 5), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit ISBN with alphanumeric characters in ISBN should not be added");
    }

    @Test
    void addBookEditISBNWithSpecialCharactersInISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "Grace", "Wilson", "12$34&567890", LocalDate.of(2023, 11, 10), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit ISBN with special characters in ISBN should not be added");
    }

    @Test
    void addBookEditISBNWithEmptyISBNDifferentName() {
        Book book = new Book(1, "Valid Title", "Harry", "Anderson", "", LocalDate.of(2023, 12, 15), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit ISBN with an empty ISBN should not be added");
    }
    // eDIT PUBLISHER DATE
    @Test
    void addBookEditPublicationDateWithValidDateDifferentName1() {
        Book book = new Book(1, "Valid Title", "Alice", "Johnson", "1234567890", LocalDate.of(2022, 1, 15), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publication date with a valid date should be added");
    }

    @Test
    void addBookEditPublicationDateWithInvalidDateDifferentName2() {
        Book book = new Book(1, "Valid Title", "Bob", "Williams", "12-345-67890", LocalDate.of(2022, 2, 30), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit publication date with an invalid date should not be added");
    }

    @Test
    void addBookEditPublicationDateWithFutureDateDifferentName3() {
        Book book = new Book(1, "Valid Title", "Charlie", "Davis", "ABCD123456", LocalDate.of(2023, 7, 20), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit publication date with a future date should not be added");
    }

    @Test
    void addBookEditPublicationDateWithPastDateDifferentName4() {
        Book book = new Book(1, "Valid Title", "David", "Miller", "1234X567890", LocalDate.of(2020, 8, 25), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publication date with a past date should be added");
    }

// EDIT GENRE
@Test
void addBookEditGenreWithValidGenreDifferentName1() {
    Book book = new Book(1, "Valid Title", "Eleanor", "Anderson", "1234567890", LocalDate.of(2022, 1, 15), "Fiction", "Standard Publishers", "Available", "New Condition");
    assertTrue(bookDAO.addBook(book), "addBook edit genre with a valid genre should be added");
}

    @Test
    void addBookEditGenreWithNonFictionDifferentName2() {
        Book book = new Book(1, "Valid Title", "Felix", "Brown", "12-345-67890", LocalDate.of(2022, 2, 30), "Non-Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Non-Fiction' should be added");
    }

    @Test
    void addBookEditGenreWithFantasyDifferentName3() {
        Book book = new Book(1, "Valid Title", "Grace", "Clark", "ABCD123456", LocalDate.of(2023, 7, 20), "Fantasy", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Fantasy' should be added");
    }

    @Test
    void addBookEditGenreWithScienceFictionDifferentName4() {
        Book book = new Book(1, "Valid Title", "Henry", "Davis", "1234X567890", LocalDate.of(2020, 8, 25), "Science Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Science Fiction' should be added");
    }

    @Test
    void addBookEditGenreWithRomanceDifferentName5() {
        Book book = new Book(1, "Valid Title", "Isabella", "Evans", "5678901234", LocalDate.of(2021, 5, 10), "Romance", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Romance' should be added");
    }

    @Test
    void addBookEditGenreWithHorrorDifferentName6() {
        Book book = new Book(1, "Valid Title", "Jack", "Foster", "9081726354", LocalDate.of(2019, 11, 5), "Horror", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Horror' should be added");
    }

    @Test
    void addBookEditGenreWithMysteryDifferentName7() {
        Book book = new Book(1, "Valid Title", "Katherine", "Garcia", "1234598760", LocalDate.of(2024, 3, 18), "Mystery", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Mystery' should be added");
    }

    @Test
    void addBookEditGenreWithAdventureDifferentName8() {
        Book book = new Book(1, "Valid Title", "Liam", "Harrison", "5647382910", LocalDate.of(2018, 9, 12), "Adventure", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Adventure' should be added");
    }

    @Test
    void addBookEditGenreWithBiographyDifferentName9() {
        Book book = new Book(1, "Valid Title", "Mia", "Irwin", "1982736450", LocalDate.of(2023, 6, 7), "Biography", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'Biography' should be added");
    }

    @Test
    void addBookEditGenreWithHistoryDifferentName10() {
        Book book = new Book(1, "Valid Title", "Noah", "Johnson", "1029384756", LocalDate.of(2022, 4, 14), "History", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit genre with 'History' should be added");
    }
// EDIT PUBLISHER NAME
@Test
void addBookEditPublisherWithValidName1() {
    Book book = new Book(1, "Valid Title", "Eleanor", "Anderson", "1234567890", LocalDate.of(2022, 1, 15), "Fiction", "Standard Publishers", "Available", "New Condition");
    assertTrue(bookDAO.addBook(book), "addBook edit publisher name with a valid name should be added");
}

    @Test
    void addBookEditPublisherWithHyphens1() {
        Book book = new Book(1, "Valid Title", "Felix", "Brown", "12-345-67890", LocalDate.of(2022, 2, 30), "Non-Fiction", "Hyphen-Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publisher name with hyphens should be added");
    }

    @Test
    void addBookEditPublisherWithLowercase1() {
        Book book = new Book(1, "Valid Title", "Grace", "Clark", "ABCD123456", LocalDate.of(2023, 7, 20), "Fantasy", "lowercase publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publisher name with lowercase should be added");
    }

    @Test
    void addBookEditPublisherWithUppercase1() {
        Book book = new Book(1, "Valid Title", "Henry", "Davis", "1234X567890", LocalDate.of(2020, 8, 25), "Science Fiction", "UPPERCASE PUBLISHERS", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publisher name with uppercase should be added");
    }

    @Test
    void addBookEditPublisherWithMixedCase1() {
        Book book = new Book(1, "Valid Title", "Isabella", "Evans", "5678901234", LocalDate.of(2021, 5, 10), "Romance", "MixedCase Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publisher name with mixed case should be added");
    }

    @Test
    void addBookEditPublisherWithApostrophe1() {
        Book book = new Book(1, "Valid Title", "Jack", "Foster", "9081726354", LocalDate.of(2019, 11, 5), "Horror", "Publisher's Name", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit publisher name with apostrophe should be added");
    }

    @Test
    void addBookEditPublisherWithSpecialCharacters1() {
        Book book = new Book(1, "Valid Title", "Katherine", "Garcia", "1234598760", LocalDate.of(2024, 3, 18), "Mystery", "Special!@# Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit publisher name with special characters should not be added");
    }

    @Test
    void addBookEditPublisherWithEmpty1() {
        Book book = new Book(1, "Valid Title", "Liam", "Harrison", "5647382910", LocalDate.of(2018, 9, 12), "Adventure", "", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit publisher name with an empty name should not be added");
    }

    @Test
    void addBookEditPublisherWithMixedCasesHyphensSpecialCharacters1() {
        Book book = new Book(1, "Valid Title", "Mia", "Irwin", "1982736450", LocalDate.of(2023, 6, 7), "Biography", "Mixed-Case!@# Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit publisher name with mixed cases, hyphens, and special characters should not be added");
    }

    @Test
    void addBookEditPublisherWithWordsAndNumbers1() {
        Book book = new Book(1, "Valid Title", "Noah", "Johnson", "1029384756", LocalDate.of(2022, 4, 14), "History", "Word123 Publishers", "Available", "New Condition");
        assertFalse(bookDAO.addBook(book), "addBook edit publisher name with words and numbers should not be added");
    }
// EDIT AVAILABILITY

    @Test
    void addBookEditAvailabilityWithValidStatus1() {
        Book book = new Book(1, "Valid Title", "Eleanor", "Anderson", "1234567890", LocalDate.of(2022, 1, 15), "Fiction", "Standard Publishers", "Available", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit availability with a valid status should be added");
    }

    @Test
    void addBookEditAvailabilityWithOnLoan1() {
        Book book = new Book(1, "Valid Title", "Felix", "Brown", "12-345-67890", LocalDate.of(2022, 2, 30), "Non-Fiction", "Hyphen-Publishers", "On Loan", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit availability with 'On Loan' status should be added");
    }

    @Test
    void addBookEditAvailabilityWithReserved1() {
        Book book = new Book(1, "Valid Title", "Grace", "Clark", "ABCD123456", LocalDate.of(2023, 7, 20), "Fantasy", "lowercase publishers", "Reserved", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit availability with 'Reserved' status should be added");
    }

    @Test
    void addBookEditAvailabilityWithRepair1() {
        Book book = new Book(1, "Valid Title", "Henry", "Davis", "1234X567890", LocalDate.of(2020, 8, 25), "Science Fiction", "UPPERCASE PUBLISHERS", "Repair", "New Condition");
        assertTrue(bookDAO.addBook(book), "addBook edit availability with 'Repair' status should be added");
    }

// CONDITIONS
@Test
void addBookEditConditionWithGood1() {
    Book book = new Book(1, "Valid Title", "Isabella", "Evans", "1234567890", LocalDate.of(2022, 3, 10), "Romance", "MixedCase Publishers", "Available", "Good");
    assertTrue(bookDAO.addBook(book), "addBook edit condition with 'Good' status should be added");
}

    @Test
    void addBookEditConditionWithFair1() {
        Book book = new Book(1, "Valid Title", "Jack", "Fisher", "12-345-67890", LocalDate.of(2021, 5, 12), "Horror", "Apostrophe's Publishers", "Available", "Fair");
        assertTrue(bookDAO.addBook(book), "addBook edit condition with 'Fair' status should be added");
    }

    @Test
    void addBookEditConditionWithPoor1() {
        Book book = new Book(1, "Valid Title", "Katherine", "Garcia", "ABCD123456", LocalDate.of(2022, 11, 5), "Mystery", "Special!@# Publishers", "Available", "Poor");
        assertTrue(bookDAO.addBook(book), "addBook edit condition with 'Poor' status should be added");
    }

    @Test
    void addBookEditConditionWithDamaged1() {
        Book book = new Book(1, "Valid Title", "Liam", "Harris", "1234X567890", LocalDate.of(2023, 9, 8), "Adventure", "Word123 Number", "Available", "Damaged");
        assertTrue(bookDAO.addBook(book), "addBook edit condition with 'Damaged' status should be added");
    }






    //BOOK MANAGER DELETE

    @Test
    void addBookDeleteBook() {
        // Create and add a book
        Book book = new Book(1, "Sample Title", "John", "Doe", "1234567890", LocalDate.of(2022, 1, 15), "Fiction", "Sample Publishers", "Available", "Good");
        assertTrue(bookDAO.addBook(book), "Adding a book should be successful");

        // Delete the added book
        //assertTrue(bookDAO.addBook(book), "Deleting the added book should be successful");
    }


    // BOOK MANAGER LOAN
    @Test
    void addBookLoan() {
        // Create and add a book
        Book book = new Book(1, "Sample Title", "John", "Doe", "1234567890", LocalDate.of(2022, 1, 15), "Fiction", "Sample Publishers", "Available", "Good");
        assertTrue(bookDAO.addBook(book), "Adding a book should be successful");


    }



}






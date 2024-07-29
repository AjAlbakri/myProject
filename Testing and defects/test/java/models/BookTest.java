package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {






        @Test
        void testBookID() {
            Book book = new Book();
            book.setBookID(123);
            assertEquals(123, book.getBookID());
        }

        @Test
        void testTitle() {
            Book book = new Book();
            book.setTitle("Charlie");
            assertEquals("Charlie", book.getTitle());
        }



        @Test
        void testAuthorFirstName() {
            Book book = new Book();
            book.setAuthorFirstName("Jho");
            assertEquals("Jho", book.getAuthorFirstName());
        }

        @Test
        void testAuthorSurname() {
            Book book = new Book();
            book.setAuthorSurname("Daniel");
            assertEquals("Daniel", book.getAuthorSurname());
        }

        @Test
        void testISBN() {
            Book book = new Book();
            book.setISBN("1234875890");
            assertEquals("1234875890", book.getISBN());
        }

        @Test
        void testPublishDate() {
            Book book = new Book();
            LocalDate date = LocalDate.of(2020, 1, 1);
            book.setPublishDate(date);
            assertEquals(date, book.getPublishDate());
        }

        @Test
        void testGenre() {
            Book book = new Book();
            book.setGenre("Fiction");
            assertEquals("Fiction", book.getGenre());
        }

        @Test
        void testPublisherName() {
            Book book = new Book();
            book.setPublisherName("Test Publisher");
            assertEquals("Test Publisher", book.getPublisherName());
        }

        @Test
        void testAvailabilityStatus() {
            Book book = new Book();
            book.setAvailabilityStatus("Available");
            assertEquals("Available", book.getAvailabilityStatus());
        }

        @Test
        void testCondition() {
            Book book = new Book();
            book.setCondition("New");
            assertEquals("New", book.getCondition());
        }

        @Test
        void testToString() {
            Book book = new Book();
            // Set all fields
            book.setTitle("Test Title");
            book.setAuthorFirstName("Abdi");
            book.setAuthorSurname("Mohamed");
            book.setISBN("1234567890");
            LocalDate date = LocalDate.of(2020, 1, 1);
            book.setPublishDate(date);
            book.setGenre("Fiction");
            book.setPublisherName("Test Publisher");
            book.setAvailabilityStatus("Available");
            book.setCondition("New");

            String expected = "Book{title='Test Title', authorFirstName='John', authorSurname='Doe', ISBN='1234567890', publishDate=2020-01-01, genre='Fiction', publisherName='Test Publisher', availabilityStatus='Available', condition='New'}";
            assertEquals(expected, book.toString());
        }


        @Test
        void testBookIDWithNull() {
            // This test might not be necessary as bookID is an int and cannot be null
        }

        @Test
        void testTitleWithNull() {
            Book book = new Book();
            book.setTitle(null);
            assertNull(book.getTitle());
        }

        @Test
        void testAuthorFirstNameWithNull() {
            Book book = new Book();
            book.setAuthorFirstName(null);
            assertNull(book.getAuthorFirstName());
        }

        @Test
        void testAuthorSurnameWithNull() {
            Book book = new Book();
            book.setAuthorSurname(null);
            assertNull(book.getAuthorSurname());
        }

        @Test
        void testISBNWithNull() {
            Book book = new Book();
            book.setISBN(null);
            assertNull(book.getISBN());
        }

        @Test
        void testPublishDateWithNull() {
            Book book = new Book();
            book.setPublishDate(null);
            assertNull(book.getPublishDate());
        }

        @Test
        void testGenreWithNull() {
            Book book = new Book();
            book.setGenre(null);
            assertNull(book.getGenre());
        }

        @Test
        void testPublisherNameWithNull() {
            Book book = new Book();
            book.setPublisherName(null);
            assertNull(book.getPublisherName());
        }

        @Test
        void testAvailabilityStatusWithNull() {
            Book book = new Book();
            book.setAvailabilityStatus(null);
            assertNull(book.getAvailabilityStatus());
        }

        @Test
        void testConditionWithNull() {
            Book book = new Book();
            book.setCondition(null);
            assertNull(book.getCondition());
        }

        // Additional test for the toString method with null values
        @Test
        void testToStringWithNullValues() {
            Book book = new Book();
            // Set all fields to null
            book.setTitle(null);
            book.setAuthorFirstName(null);
            book.setAuthorSurname(null);
            book.setISBN(null);
            book.setPublishDate(null);
            book.setGenre(null);
            book.setPublisherName(null);
            book.setAvailabilityStatus(null);
            book.setCondition(null);

            String expected = "Book{title='null', authorFirstName='null', authorSurname='null', ISBN='null', publishDate=null, genre='null', publisherName='null', availabilityStatus='null', condition='null'}";
            assertEquals(expected, book.toString());
        }


        @Test
        void testTitleWithLowerCase() {
            Book book = new Book();
            book.setTitle("lowercase title");
            assertEquals("lowercase title", book.getTitle());
        }

        @Test
        void testTitleWithUpperCase() {
            Book book = new Book();
            book.setTitle("UPPERCASE TITLE");
            assertEquals("UPPERCASE TITLE", book.getTitle());
        }

        @Test
        void testTitleWithMixedCase() {
            Book book = new Book();
            book.setTitle("MixedCase Title");
            assertEquals("MixedCase Title", book.getTitle());
        }

        @Test
        void testTitleWithNumbers() {
            Book book = new Book();
            book.setTitle("1234567890");
            assertEquals("1234567890", book.getTitle());
        }

        @Test
        void testTitleWithAlphanumeric() {
            Book book = new Book();
            book.setTitle("Title123");
            assertEquals("Title123", book.getTitle());
        }

        @Test
        void testTitleWithLongString() {
            Book book = new Book();
            String longTitle = "This is a very long book title, possibly the longest ever seen, stretching beyond normal title lengths";
            book.setTitle(longTitle);
            assertEquals(longTitle, book.getTitle());
        }


        @Test
        void testAuthorFirstNameWithLowerCase() {
            Book book = new Book();
            book.setAuthorFirstName("Omar");
            assertEquals("Omar", book.getAuthorFirstName());
        }

        @Test
        void testAuthorFirstNameWithUpperCase() {
            Book book = new Book();
            book.setAuthorFirstName("Omar");
            assertEquals("Omar", book.getAuthorFirstName());
        }

        @Test
        void testAuthorFirstNameWithMixedCase() {
            Book book = new Book();
            book.setAuthorFirstName("Omar");
            assertEquals("Omar", book.getAuthorFirstName());
        }

        @Test
        void testAuthorFirstNameWithNumbers() {
            Book book = new Book();
            book.setAuthorFirstName("1234567890");
            assertEquals("1234567890", book.getAuthorFirstName());
        }

        @Test
        void testAuthorFirstNameWithAlphanumeric() {
            Book book = new Book();
            book.setAuthorFirstName("Myg123");
            assertEquals("Myg123", book.getAuthorFirstName());
        }

        @Test
        void testAuthorFirstNameWithLongString() {
            Book book = new Book();
            String longFirstName = "ThisIsAVeryLongFirstNamePossiblyTheLongestEverSeenStretchingBeyondNormalLengths";
            book.setAuthorFirstName(longFirstName);
            assertEquals(longFirstName, book.getAuthorFirstName());
        }


        @Test
        void testAuthorSurnameWithLowerCase() {
            Book book = new Book();
            book.setAuthorSurname("daniel");
            assertEquals("daniel", book.getAuthorSurname());
        }

        @Test
        void testAuthorSurnameWithUpperCase() {
            Book book = new Book();
            book.setAuthorSurname("Danish");
            assertEquals("Danish", book.getAuthorSurname());
        }

        @Test
        void testAuthorSurnameWithMixedCase() {
            Book book = new Book();
            book.setAuthorSurname("Dab");
            assertEquals("Dab", book.getAuthorSurname());
        }

        @Test
        void testAuthorSurnameWithNumbers() {
            Book book = new Book();
            book.setAuthorSurname("4567890");
            assertEquals("4567890", book.getAuthorSurname());
        }

        @Test
        void testAuthorSurnameWithAlphanumeric() {
            Book book = new Book();
            book.setAuthorSurname("AJ123");
            assertEquals("AJ123", book.getAuthorSurname());
        }

        @Test
        void testAuthorSurnameWithLongString() {
            Book book = new Book();
            String longSurname = "ThisIsAVeryLongSurnamePossiblyTheLongestEverSeenStretchingBeyondNormalLengths";
            book.setAuthorSurname(longSurname);
            assertEquals(longSurname, book.getAuthorSurname());
        }


        @Test
        void testISBNWithValidNumber() {
            Book book = new Book();
            book.setISBN("9783161484100"); // Example of a valid ISBN-13
            assertEquals("9783161484100", book.getISBN());
        }

        @Test
        void testISBNWithWords() {
            Book book = new Book();
            book.setISBN("invalidISBN");
            assertEquals("invalidISBN", book.getISBN(), "Currently, the Book class accepts any string as ISBN.");
        }

        @Test
        void testISBNWithCharacters() {
            Book book = new Book();
            book.setISBN("#$%^&*");
            assertEquals("#$%^&*", book.getISBN(), "Currently, the Book class accepts any string as ISBN.");
        }


        @Test
        void testPublishDateWithValidDate() {
            Book book = new Book();
            LocalDate validDate = LocalDate.of(2000, 1, 1); // A past date
            book.setPublishDate(validDate);
            assertEquals(validDate, book.getPublishDate());
        }

        @Test
        void testPublishDateWithFutureDate() {
            Book book = new Book();
            LocalDate futureDate = LocalDate.now().plusYears(1); // A future date
            book.setPublishDate(futureDate);
            assertEquals(futureDate, book.getPublishDate(), "The Book class accepts future dates.");
        }


        @Test
        void testGenreWithEmptyString() {
            Book book = new Book();
            book.setGenre("");
            assertEquals("", book.getGenre());
        }

        @Test
        void testGenreWithSpecialCharacters() {
            Book book = new Book();
            book.setGenre("@#$%^&*");
            assertEquals("@#$%^&*", book.getGenre());
        }

        @Test
        void testGenreWithAlphanumericCombination() {
            Book book = new Book();
            book.setGenre("SciFi123");
            assertEquals("SciFi123", book.getGenre());
        }

        @Test
        void testGenreWithHyphens() {
            Book book = new Book();
            book.setGenre("Non-Fiction");
            assertEquals("Non-Fiction", book.getGenre());
        }

        @Test
        void testGenreWithDuplicates() {
            Book book = new Book();
            book.setGenre("Mystery");
            book.setGenre("Mystery"); // Setting the same genre again
            assertEquals("Mystery", book.getGenre());
        }

        @Test
        void testGenreWithLongString() {
            Book book = new Book();
            String longGenre = "ThisIsAnExtremelyLongGenreNameThatExceedsNormalGenreNameLengthsAndIsUsedForTestingPurposes";
            book.setGenre(longGenre);
            assertEquals(longGenre, book.getGenre());
        }


        @Test
        void testConditionWithMultipleConditions() {
            Book book = new Book();
            book.setCondition("Used - Good");
            assertEquals("Used - Good", book.getCondition());
        }

        @Test
        void testConditionWithNoCondition() {
            Book book = new Book();
            book.setCondition("");
            assertEquals("", book.getCondition());
        }

        @Test
        void testConditionWithSingleCondition() {
            Book book = new Book();
            book.setCondition("New");
            assertEquals("New", book.getCondition());
        }

        @Test
        void testConditionWithSpecialCharacters() {
            Book book = new Book();
            book.setCondition("!@#$%^&*()");
            assertEquals("!@#$%^&*()", book.getCondition());
        }

        @Test
        void testConditionWithNumeric() {
            Book book = new Book();
            book.setCondition("12345");
            assertEquals("12345", book.getCondition());
        }

        @Test
        void testConditionWithExtendedLength() {
            Book book = new Book();
            String longCondition = "ThisIsAnExtremelyLongConditionStringThatExceedsNormalConditionStringLengths";
            book.setCondition(longCondition);
            assertEquals(longCondition, book.getCondition());
        }

        //publisher


        @Test
        void testPublisherNameWithSpecialCharacters() {
            Book book = new Book();
            book.setPublisherName("@#$%^&*");
            assertEquals("@#$%^&*", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithNumeric() {
            Book book = new Book();
            book.setPublisherName("12345");
            assertEquals("12345", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithExtendedLength() {
            Book book = new Book();
            String longPublisherName = "ThisIsAnExtremelyLongPublisherNameThatExceedsNormalPublisherNameLengths";
            book.setPublisherName(longPublisherName);
            assertEquals(longPublisherName, book.getPublisherName());
        }

        @Test
        void testPublisherNameWithSpaces() {
            Book book = new Book();
            book.setPublisherName("Publisher Name With Spaces");
            assertEquals("Publisher Name With Spaces", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithHyphens() {
            Book book = new Book();
            book.setPublisherName("Hyphen-Name");
            assertEquals("Hyphen-Name", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithUppercase() {
            Book book = new Book();
            book.setPublisherName("UPPERCASE");
            assertEquals("UPPERCASE", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithLowercase() {
            Book book = new Book();
            book.setPublisherName("lowercase");
            assertEquals("lowercase", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithMixedCase() {
            Book book = new Book();
            book.setPublisherName("MixedCase");
            assertEquals("MixedCase", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithEmpty() {
            Book book = new Book();
            book.setPublisherName("");
            assertEquals("", book.getPublisherName());
        }

        @Test
        void testPublisherNameWithDuplicate() {
            Book book = new Book();
            book.setPublisherName("Duplicate");
            book.setPublisherName("Duplicate");
            assertEquals("Duplicate", book.getPublisherName());
        }

        // availability

        @Test
        void testAvailabilityWithBlank() {
            Book book = new Book();
            book.setAvailabilityStatus(""); // Setting blank availability
            assertEquals("", book.getAvailabilityStatus());
        }

        @Test
        void testAvailabilityWithChangingStatus() {
            Book book = new Book();
            book.setAvailabilityStatus("Available");
            assertEquals("Available", book.getAvailabilityStatus());

            book.setAvailabilityStatus("Checked Out");
            assertEquals("Checked Out", book.getAvailabilityStatus());
        }

        // this bit is editing title


        @Test
        void testEditTitleWithValidInput() {
            Book book = new Book();
            book.setTitle("Valid Title");
            assertEquals("Valid Title", book.getTitle());
        }

        @Test
        void testEditTitleWithSpecialCharacters() {
            Book book = new Book();
            book.setTitle("@#$%^&*");
            assertEquals("@#$%^&*", book.getTitle());
        }

        @Test
        void testEditTitleWithEmpty() {
            Book book = new Book();
            book.setTitle("");
            assertEquals("", book.getTitle());
        }


        @Test
        void testEditTitleWithDuplicate() {
            Book book = new Book();
            book.setTitle("Duplicate Title");
            book.setTitle("Duplicate Title");
            assertEquals("Duplicate Title", book.getTitle());
        }

        @Test
        void testEditTitleWithAlphanumeric() {
            Book book = new Book();
            book.setTitle("Title123");
            assertEquals("Title123", book.getTitle());
        }

        @Test
        void testEditTitleWithLineBreaks() {
            Book book = new Book();
            book.setTitle("Line\nBreak");
            assertEquals("Line\nBreak", book.getTitle());
        }

        @Test
        void testEditTitleWithLowercase() {
            Book book = new Book();
            book.setTitle("lowercase title");
            assertEquals("lowercase title", book.getTitle());
        }

        @Test
        void testEditTitleWithUppercase() {
            Book book = new Book();
            book.setTitle("UPPERCASE TITLE");
            assertEquals("UPPERCASE TITLE", book.getTitle());
        }

        @Test
        void testEditTitleWithMixedCases() {
            Book book = new Book();
            book.setTitle("MixedCase Title");
            assertEquals("MixedCase Title", book.getTitle());
        }

        @Test
        void testEditTitleWithAlphanumericSpacesSpecialChars() {
            Book book = new Book();
            book.setTitle("Title 123 @#$");
            assertEquals("Title 123 @#$", book.getTitle());
        }

        //  firsName editing


        @Test
        void testEditAuthorFirstNameWithValidInput() {
            Book book = new Book();
            book.setAuthorFirstName("John");
            assertEquals("John", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithBlankField() {
            Book book = new Book();
            book.setAuthorFirstName("");
            assertEquals("", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithSpecialCharacters() {
            Book book = new Book();
            book.setAuthorFirstName("@#$%");
            assertEquals("@#$%", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithNumericCharacters() {
            Book book = new Book();
            book.setAuthorFirstName("1234");
            assertEquals("1234", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithUppercase() {
            Book book = new Book();
            book.setAuthorFirstName("JOHN");
            assertEquals("JOHN", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithLowercase() {
            Book book = new Book();
            book.setAuthorFirstName("john");
            assertEquals("john", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithMixedCase() {
            Book book = new Book();
            book.setAuthorFirstName("JohnDoe");
            assertEquals("JohnDoe", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithAlphanumeric() {
            Book book = new Book();
            book.setAuthorFirstName("John123");
            assertEquals("John123", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithHyphens() {
            Book book = new Book();
            book.setAuthorFirstName("Anne-Marie");
            assertEquals("Anne-Marie", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithHyphensAndNumericCharacters() {
            Book book = new Book();
            book.setAuthorFirstName("John-2");
            assertEquals("John-2", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithDiacriticalMarks() {
            Book book = new Book();
            book.setAuthorFirstName("Jos");
            assertEquals("Jos", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithMixedCaseHyphenAndSpecialCharacters() {
            Book book = new Book();
            book.setAuthorFirstName("John-Doe@#");
            assertEquals("John-Doe@#", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithApostrophe() {
            Book book = new Book();
            book.setAuthorFirstName("O'Connor");
            assertEquals("O'Connor", book.getAuthorFirstName());
        }

        @Test
        void testEditAuthorFirstNameWithApostropheAndNumericCharacters() {
            Book book = new Book();
            book.setAuthorFirstName("O'Con3or");
            assertEquals("O'Con3or", book.getAuthorFirstName());
        }

        // surname editing


        @Test
        void testEditAuthorSurnameWithValidInput() {
            Book book = new Book();
            book.setAuthorSurname("ABDI");
            assertEquals("ABDI", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithBlankField() {
            Book book = new Book();
            book.setAuthorSurname("");
            assertEquals("", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithSpecialCharacters() {
            Book book = new Book();
            book.setAuthorSurname("@#$%");
            assertEquals("@#$%", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithNumericCharacters() {
            Book book = new Book();
            book.setAuthorSurname("12735");
            assertEquals("13562", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithUppercase() {
            Book book = new Book();
            book.setAuthorSurname("Muk");
            assertEquals("Muk", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithLowercase() {
            Book book = new Book();
            book.setAuthorSurname("Muk");
            assertEquals("MuK", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithMixedCase() {
            Book book = new Book();
            book.setAuthorSurname("Muk");
            assertEquals("Muk", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithAlphanumeric() {
            Book book = new Book();
            book.setAuthorSurname("Muk123");
            assertEquals("Muk123", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithHyphens() {
            Book book = new Book();
            book.setAuthorSurname("Rodriguez-Lopez");
            assertEquals("Rodriguez-Lopez", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithHyphensAndNumericCharacters() {
            Book book = new Book();
            book.setAuthorSurname("Ahmed-2");
            assertEquals("Ahmed-2", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithDiacriticalMarks() {
            Book book = new Book();
            book.setAuthorSurname("Bron");
            assertEquals("Bron", book.getAuthorSurname());
        }

        @Test
        void testEditAuthorSurnameWithMixedCaseHyphenAndSpecialCharacters() {
            Book book = new Book();
            book.setAuthorSurname("AJ@#");
            assertEquals("AJ@#", book.getAuthorSurname());
        }

        // ISBN editing


        @Test
        void testISBNWithInvalidInput() {
            Book book = new Book();
            book.setISBN("InvalidISBN");
            assertEquals("InvalidISBN", book.getISBN());
        }

        @Test
        void testISBNWithEmpty() {
            Book book = new Book();
            book.setISBN("");
            assertEquals("", book.getISBN());
        }

        @Test
        void testISBNWithNumbersAndWords() {
            Book book = new Book();
            book.setISBN("ISBN12345ABC");
            assertEquals("ISBN12345ABC", book.getISBN());
        }

        @Test
        void testISBNWithSpecialCharacters() {
            Book book = new Book();
            book.setISBN("!@#$%^&*");
            assertEquals("!@#$%^&*", book.getISBN());
        }

        @Test
        void testISBNWithHyphens() {
            Book book = new Book();
            book.setISBN("978-3-16-148410-0"); // Example of a typical ISBN-13 with hyphens
            assertEquals("978-3-16-148410-0", book.getISBN());
        }

        @Test
        void testISBNWithMixedCases() {
            Book book = new Book();
            book.setISBN("IsBn12345aBc");
            assertEquals("IsBn12345aBc", book.getISBN());
        }

        @Test
        void testISBNWithAlphanumericAndSpecialCharacters() {
            Book book = new Book();
            book.setISBN("ISBN12345@#$");
            assertEquals("ISBN12345@#$", book.getISBN());
        }

        @Test
        void testISBNWithLowercase() {
            Book book = new Book();
            book.setISBN("isbn12345abc");
            assertEquals("isbn12345abc", book.getISBN());
        }

        @Test
        void testISBNWithUppercase() {
            Book book = new Book();
            book.setISBN("ISBN12345ABC");
            assertEquals("ISBN12345ABC", book.getISBN());
        }
    }

    // Add more tests here if needed


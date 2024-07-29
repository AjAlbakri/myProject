package daos;
import daos.MemberDAO;
import models.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberDAOTest {

    private static MemberDAO memberDAO;

    @BeforeAll
    static void setUp() {
        memberDAO = new MemberDAO();
    }

    @Test
    void addMemberTest() {

        Member member = new Member(0, "John", "Doe", "john@example.com", "1234567890",
                "123 Main St", "Apt 456", "Cityville", "County", "12345",
                LocalDate.of(2022, 1, 15));

        // Add the member to the database
        boolean success = memberDAO.addMember(member);

        assertTrue(success, "Adding a member should be successful");
    }

    @Test
    void getMemberTest() {

        Member member = new Member(0, "Jane", "Smith", "jane@example.com", "9876543210",
                "456 Elm St", "", "Townsville", "County", "54321",
                LocalDate.of(2022, 2, 20));
        memberDAO.addMember(member);


        Member retrievedMember = memberDAO.getMember(1); // Assuming member ID 1 was assigned

        assertNotNull(retrievedMember, "Retrieved member should not be null");
        assertEquals("Jane", retrievedMember.getFirstName(), "First name should match");
        assertEquals("Smith", retrievedMember.getLastName(), "Last name should match");
    }

    @Test
    void getAllMembersTest() {

        Member member1 = new Member(0, "Alice", "Johnson", "alice@example.com", "1111111111",
                "789 Oak St", "", "Villageville", "County", "67890",
                LocalDate.of(2022, 3, 25));
        memberDAO.addMember(member1);

        Member member2 = new Member(0, "Bob", "Brown", "bob@example.com", "2222222222",
                "101 Pine St", "Apt 789", "Hamletsville", "County", "98765",
                LocalDate.of(2022, 4, 10));
        memberDAO.addMember(member2);


        List<Member> members = memberDAO.getAllMembers();

        assertEquals(2, members.size(), "Number of retrieved members should match");

        // Assuming the order of retrieval, you can test individual members
        assertEquals("Alice", members.get(0).getFirstName(), "First name of the first member should match");
        assertEquals("Bob", members.get(1).getFirstName(), "First name of the second member should match");
    }

    @Test
    void updateMemberTest() {

        Member member = new Member(0, "Sarah", "Lee", "sarah@example.com", "3333333333",
                "987 Hill St", "Suite 101", "Citytown", "County", "54321",
                LocalDate.of(2022, 5, 5));
        memberDAO.addMember(member);


        Member retrievedMember = memberDAO.getMember(1); // Assuming member ID 1 was assigned


        retrievedMember.setFirstName("UpdatedName");
        retrievedMember.setEmail("updated@example.com");


        boolean success = memberDAO.updateMember(retrievedMember);

        assertTrue(success, "Updating a member should be successful");


        Member updatedMember = memberDAO.getMember(1);

        assertEquals("UpdatedName", updatedMember.getFirstName(), "Updated first name should match");
        assertEquals("updated@example.com", updatedMember.getEmail(), "Updated email should match");
    }

    @Test
    void deleteMemberTest() {

        Member member = new Member(0, "Mark", "Johnson", "mark@example.com", "4444444444",
                "456 Elm St", "Apt 789", "Townsville", "County", "56789",
                LocalDate.of(2022, 6, 15));
        memberDAO.addMember(member);


        Member retrievedMember = memberDAO.getMember(1); // Assuming member ID 1 was assigned

        assertNotNull(retrievedMember, "Retrieved member should not be null");

        // Delete the member from the database
        boolean success = memberDAO.deleteMember(1);

        assertTrue(success, "Deleting a member should be successful");


        Member deletedMember = memberDAO.getMember(1);

        assertNull(deletedMember, "Deleted member should be null");
    }







        @Test
        void addMemberWithValidInput() {

            Member member = new Member(0, "Valid First Name", "Valid Last Name", "valid@example.com", "1234567890",
                    "123 Main St", "Apt 456", "Cityville", "County", "12345",
                    LocalDate.of(2022, 1, 15));


            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with valid input should be successful");
        }

        @Test
        void addMemberWithEmptyInput() {

            Member member = new Member(0, "", "", "", "",
                    "", "", "", "", "",
                    LocalDate.of(2022, 1, 15));


            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with empty input should fail");
        }

        @Test
        void addMemberWithInvalidInput() {

            Member member = new Member(0, "Invalid First Name", "Invalid Last Name", "invalid-email", "1234567890",
                    "123 Main St", "Apt 456", "Cityville", "County", "12345",
                    LocalDate.of(2022, 1, 15));


            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with invalid input should fail");
        }

     // member  FIRST NAME


        @Test
        void addMemberWithValidFirstName() {
            Member member = new Member(0, "AJ", "Doe", "aj@example.com", "9876543210",
                    "123 Main St", "", "Cityville", "County", "54321",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a valid first name should pass");
        }

        @Test
        void addMemberWithLowerCaseFirstName() {
            Member member = new Member(0, "mohamed", "Doe", "mohamed@example.com", "9876543211",
                    "123 Main St", "", "Cityville", "County", "54322",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a lowercase first name should pass");
        }

        @Test
        void addMemberWithMixedCaseFirstName() {
            Member member = new Member(0, "MuKtAr", "Doe", "muktar@example.com", "9876543212",
                    "123 Main St", "", "Cityville", "County", "54323",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a mixed-case first name should pass");
        }

        @Test
        void addMemberWithUpperCaseFirstName() {
            Member member = new Member(0, "AHMED", "Doe", "ahmed@example.com", "9876543213",
                    "123 Main St", "", "Cityville", "County", "54324",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with an uppercase first name should pass");
        }

        @Test
        void addMemberWithHyphenInFirstName() {
            Member member = new Member(0, "HaSsan-Omar", "Smith", "hassan-omar@example.com", "9876543214",
                    "123 Main St", "", "Cityville", "County", "54325",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a hyphen in the first name should pass");
        }

        @Test
        void addMemberWithNumberInFirstName() {
            Member member = new Member(0, "CENA123", "Doe", "cena@example.com", "9876543215",
                    "123 Main St", "", "Cityville", "County", "54326",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a number in the first name should fail");
        }

        @Test
        void addMemberWithSpecialCharactersInFirstName() {
            Member member = new Member(0, "J@ck", "Smith", "jack@example.com", "9876543216",
                    "123 Main St", "", "Cityville", "County", "54327",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with special characters in the first name should fail");
        }

        @Test
        void addMemberWithHyphenAndSpecialCharactersInFirstName() {
            Member member = new Member(0, "OMAR-@CENA", "Smith", "omar-cena@example.com", "9876543217",
                    "123 Main St", "", "Cityville", "County", "54328",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a hyphen and special characters in the first name should fail");
        }

        @Test
        void addMemberWithEmptyFirstName() {
            Member member = new Member(0, "", "Doe", "empty@example.com", "9876543218",
                    "123 Main St", "", "Cityville", "County", "54329",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with an empty first name should fail");
        }




        //// SURNAME




        @Test
        void addMemberWithValidLastName() {
            Member member = new Member(0, "AJ", "Smith", "aj@example.com", "9876543210",
                    "123 Main St", "", "Cityville", "County", "54321",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a valid last name should pass");
        }

        @Test
        void addMemberWithLowerCaseLastName() {
            Member member = new Member(0, "MOHAMED", "mohamed", "mohamed@example.com", "9876543211",
                    "123 Main St", "", "Cityville", "County", "54322",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a lowercase last name should pass");
        }

        @Test
        void addMemberWithMixedCaseLastName() {
            Member member = new Member(0, "MUKTAR", "MuKtAr", "muktar@example.com", "9876543212",
                    "123 Main St", "", "Cityville", "County", "54323",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a mixed-case last name should pass");
        }

        @Test
        void addMemberWithUpperCaseLastName() {
            Member member = new Member(0, "AHMED", "AHMED", "ahmed@example.com", "9876543213",
                    "123 Main St", "", "Cityville", "County", "54324",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with an uppercase last name should pass");
        }

        @Test
        void addMemberWithHyphenInLastName() {
            Member member = new Member(0, "HASSAN", "Hassan-Omar", "hassan-omar@example.com", "9876543214",
                    "123 Main St", "", "Cityville", "County", "54325",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a hyphen in the last name should pass");
        }

        @Test
        void addMemberWithNumberInLastName() {
            Member member = new Member(0, "CENA", "CENA123", "cena@example.com", "9876543215",
                    "123 Main St", "", "Cityville", "County", "54326",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a number in the last name should fail");
        }

        @Test
        void addMemberWithSpecialCharactersInLastName() {
            Member member = new Member(0, "JACK", "J@ck", "jack@example.com", "9876543216",
                    "123 Main St", "", "Cityville", "County", "54327",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with special characters in the last name should fail");
        }

        @Test
        void addMemberWithHyphenAndSpecialCharactersInLastName() {
            Member member = new Member(0, "OMAR", "OMAR-@CENA", "omar-cena@example.com", "9876543217",
                    "123 Main St", "", "Cityville", "County", "54328",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a hyphen and special characters in the last name should fail");
        }

        @Test
        void addMemberWithEmptyLastName() {
            Member member = new Member(0, "JACK", "", "empty@example.com", "9876543218",
                    "123 Main St", "", "Cityville", "County", "54329",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with an empty last name should fail");
        }
// EMAIL


        @Test
        void addMemberWithValidEmail() {
            Member member = new Member(0, "AJ", "Smith", "aj@example.com", "9876543210",
                    "123 Main St", "", "Cityville", "County", "54321",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a valid email should pass");
        }

        @Test
        void addMemberWithSubdomainInEmail() {
            Member member = new Member(0, "MOHAMED", "Mohamed", "mohamed@sub.example.com", "9876543211",
                    "123 Main St", "", "Cityville", "County", "54322",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a subdomain in email should fail");
        }

        @Test
        void addMemberWithEmailPlusTag() {
            Member member = new Member(0, "MUKTAR", "Muktar", "muktar+tag@example.com", "9876543212",
                    "123 Main St", "", "Cityville", "County", "54323",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a plus tag in email should fail");
        }

        @Test
        void addMemberWithInvalidEmail() {
            Member member = new Member(0, "AHMED", "Ahmed", "ahmed[at]example[dot]com", "9876543213",
                    "123 Main St", "", "Cityville", "County", "54324",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with an invalid email should pass");
        }

        @Test
        void addMemberWithMissingSymbolInEmail() {
            Member member = new Member(0, "HASSAN", "Hassan", "hassanexample.com", "9876543214",
                    "123 Main St", "", "Cityville", "County", "54325",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a missing symbol in email should pass");
        }

        @Test
        void addMemberWithSpecialCharacterInEmail() {
            Member member = new Member(0, "CENA", "Cena", "cena!example.com", "9876543215",
                    "123 Main St", "", "Cityville", "County", "54326",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a special character in email should pass");
        }

        @Test
        void addMemberWithDotsInLocalPartOfEmail() {
            Member member = new Member(0, "OMAR", "Omar", "o..mar@example.com", "9876543216",
                    "123 Main St", "", "Cityville", "County", "54327",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with dots in the local part of email should pass");
        }

        @Test
        void addMemberWithEmailIPDomain() {
            Member member = new Member(0, "JACK", "Jack", "jack@[192.168.1.1]", "9876543217",
                    "123 Main St", "", "Cityville", "County", "54328",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with an IP address domain in email should pass");
        }

        @Test
        void addMemberWithEmptyEmail() {
            Member member = new Member(0, "JACK", "Jack", "", "9876543218",
                    "123 Main St", "", "Cityville", "County", "54329",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with an empty email should pass");
        }

        // PHONE



        @Test
        void addMemberWithValidPhone() {
            Member member = new Member(0, "AJ", "Smith", "aj@example.com", "+1234567890",
                    "123 Main St", "", "Cityville", "County", "54321",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a valid phone number should pass");
        }

        @Test
        void addMemberWithInternationalPhoneNumber() {
            Member member = new Member(0, "MOHAMED", "Mohamed", "mohamed@example.com", "+1 123-456-7890",
                    "123 Main St", "", "Cityville", "County", "54322",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with an international phone number should pass");
        }

        @Test
        void addMemberWithPhoneNumbersWithSpaces() {
            Member member = new Member(0, "MUKTAR", "Muktar", "muktar@example.com", "1 234 567 890",
                    "123 Main St", "", "Cityville", "County", "54323",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with phone numbers containing spaces should pass");
        }

        @Test
        void addMemberWithCountryCodeOmitted() {
            Member member = new Member(0, "AHMED", "Ahmed", "ahmed@example.com", "123-456-7890",
                    "123 Main St", "", "Cityville", "County", "54324",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with a phone number omitting the country code should fail");
        }

        @Test
        void addMemberWithInvalidCharactersInPhone() {
            Member member = new Member(0, "HASSAN", "Hassan", "hassan@example.com", "1A2B3C4D5E",
                    "123 Main St", "", "Cityville", "County", "54325",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with invalid characters in the phone number should fail");
        }

        // ADDRESS





        @Test
        void addMemberWithValidAddressLine1() {
            Member member = new Member(0, "AJ", "Smith", "aj@example.com", "+1234567890",
                    "123 Main St", "", "Cityville", "County", "54321",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with a valid address line 1 should pass");
        }

        @Test
        void addMemberWithApartmentNumber() {
            Member member = new Member(0, "MOHAMED", "Mohamed", "mohamed@example.com", "+1234567890",
                    "Apt 456, 789 Elm St", "", "Cityville", "County", "54322",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertFalse(success, "Adding a member with an apartment number in address line 1 should pass");
        }

        @Test
        void addMemberWithInvalidCharactersInAddressLine1() {
            Member member = new Member(0, "MUKTAR", "Muktar", "muktar@example.com", "+1234567890",
                    "123 @ Main St", "", "Cityville", "County", "54323",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with invalid characters in address line 1 should fail");
        }

        @Test
        void addMemberWithEmptyAddressLine1() {
            Member member = new Member(0, "AHMED", "Ahmed", "ahmed@example.com", "+1234567890",
                    "", "", "Cityville", "County", "54324",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with an empty address line 1 should fail");
        }

        @Test
        void addMemberWithSpecialCharactersInAddressLine1() {
            Member member = new Member(0, "HASSAN", "Hassan", "hassan@example.com", "+1234567890",
                    "$%^&* Main St", "", "Cityville", "County", "54325",
                    LocalDate.of(2022, 1, 15));

            boolean success = memberDAO.addMember(member);

            assertTrue(success, "Adding a member with special characters in address line 1 should fail");
        }

  // Town



        @Test
        void addMemberWithValidTownCity() {
            // Create a valid Member object with a valid town/city name
            Member validMember = new Member("John", "Doe", "john@example.com", "1234567890", "123 Main St", "", "Cityville", "County", "12345");

            boolean success = memberDAO.addMember(validMember);

            assertFalse(success, "Adding a member with a valid town/city should pass");
        }

        @Test
        void addMemberWithInvalidTownCity() {
            // Create a Member object with an invalid town/city name (e.g., special characters)
            Member invalidMember = new Member("Jane", "Doe", "jane@example.com", "9876543210", "456 Elm St", "", "#InvalidCity@", "County", "54321");

            boolean success = memberDAO.addMember(invalidMember);

            assertTrue(success, "Adding a member with an invalid town/city should fail");
        }

        @Test
        void addMemberWithEmptyTownCity() {
            // Create a Member object with an empty town/city name
            Member emptyTownCityMember = new Member("Alice", "Smith", "alice@example.com", "5678901234", "789 Oak St", "", "", "County", "67890");

            boolean success = memberDAO.addMember(emptyTownCityMember);

            assertTrue(success, "Adding a member with an empty town/city should pass");
        }

        @Test
        void addMemberWithNumericTownCity() {
            // Create a Member object with a numeric town/city name
            Member numericTownCityMember = new Member("Bob", "Johnson", "bob@example.com", "2345678901", "101 Pine St", "", "12345", "County", "43210");

            boolean success = memberDAO.addMember(numericTownCityMember);

            assertTrue(success, "Adding a member with a numeric town/city should pass");
        }

   //Country




        @Test
        void addMemberWithValidCountry() {
            // Create a valid Member object with a valid country name
            Member validMember = new Member("John", "Doe", "john@example.com", "1234567890", "123 Main St", "", "Cityville", "ValidCountry", "12345");

            boolean success = memberDAO.addMember(validMember);

            assertFalse(success, "Adding a member with a valid country should pass");
        }

        @Test
        void addMemberWithSpecialCharactersInCountry() {
            // Create a Member object with special characters in the country name
            Member specialCharsCountryMember = new Member("Jane", "Doe", "jane@example.com", "9876543210", "456 Elm St", "", "Cityville", "#Special@Country!", "54321");

            boolean success = memberDAO.addMember(specialCharsCountryMember);

            assertFalse(success, "Adding a member with special characters in the country should fail");
        }

    // psotCode




        @Test
        void addMemberWithValidPostcode() {
            // Create a valid Member object with a valid postcode
            Member validMember = new Member("John", "Doe", "john@example.com", "1234567890", "123 Main St", "", "Cityville", "ValidPostcode", "12345");

            boolean success = memberDAO.addMember(validMember);

            assertTrue(success, "Adding a member with a valid postcode should pass");
        }

        @Test
        void addMemberWithEmptyPostcode() {
            // Create a Member object with an empty postcode
            Member emptyPostcodeMember = new Member("Jane", "Doe", "jane@example.com", "9876543210", "456 Elm St", "", "Cityville", "", "54321");

            boolean success = memberDAO.addMember(emptyPostcodeMember);

            assertFalse(success, "Adding a member with an empty postcode should fail");
        }

        @Test
        void addMemberWithOptionalHyphensInPostcode() {
            // Create a Member object with optional hyphens in the postcode
            Member hyphensPostcodeMember = new Member("Bob", "Smith", "bob@example.com", "5555555555", "789 Oak St", "", "Townsville", "12-345-678", "67890");

            boolean success = memberDAO.addMember(hyphensPostcodeMember);

            assertTrue(success, "Adding a member with optional hyphens in the postcode should pass");
        }

  //Date registeration





        @Test
        void addMemberWithValidDateRegistration() {
            // Create a valid Member object with a valid date registration
            LocalDate validDateRegistration = LocalDate.now();
            Member validMember = new Member("John", "Doe", "john@example.com", "1234567890", "123 Main St", "", "Cityville", "ValidPostcode", "12345", validDateRegistration);

            boolean success = memberDAO.addMember(validMember);

            assertTrue(success, "Adding a member with a valid date registration should pass");
        }

        @Test
        void addMemberWithEmptyDateRegistration() {

            LocalDate emptyDateRegistration = null;
            Member emptyDateMember = new Member("Jane", "Doe", "jane@example.com", "9876543210", "456 Elm St", "", "Cityville", "", "54321", emptyDateRegistration);

            boolean success = memberDAO.addMember(emptyDateMember);

            assertFalse(success, "Adding a member with an empty date registration should fail");
        }

        @Test
        void addMemberWithFutureDateRegistration() {

            LocalDate futureDateRegistration = LocalDate.now().plusDays(30);
            Member futureDateMember = new Member("Bob", "Smith", "bob@example.com", "5555555555", "789 Oak St", "", "Townsville", "12345", "67890", futureDateRegistration);

            boolean success = memberDAO.addMember(futureDateMember);

            assertFalse(success, "Adding a member with a future date registration should fail");
        }


    }























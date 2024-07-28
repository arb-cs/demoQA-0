package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillStudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillStudentFormTest() {
        registrationPage.openPage()
                        .removeUnnecessaryElementsFromPage()
                        .setFirstName("Dana")
                        .setLastName("Scully")
                        .setEmail("dana_scully@xfiles.com")
                        .setGender("Female")
                        .setPhoneNumberInput("9881234567")
                        .setBirthDate("12", "December", "1990")
                        .setSubjects("Arts")
                        .setHobbies("Reading")
                        .setPicture("s3e20.png")
                        .setAddress("We're somewhere in the woods chasing aliens.")
                        .setState("NCR")
                        .setCity("Delhi")
                        .clickSubmit()
                        .validateResult("Student Name", "Dana Scully")
                        .validateResult("Student Email", "dana_scully@xfiles.com")
                        .validateResult("Gender", "Female")
                        .validateResult("Mobile", "9881234567")
                        .validateResult("Date of Birth", "12 December,1990")
                        .validateResult("Subjects", "Arts")
                        .validateResult("Hobbies", "Reading")
                        .validateResult("Picture", " s3e20.png")
                        .validateResult("Address", "We're somewhere in the woods chasing aliens.")
                        .validateResult("State and City", "NCR Delhi");
    }

    @Test
    void fillOnlyRequiredFieldsTest() {
        registrationPage.openPage()
                .removeUnnecessaryElementsFromPage()
                .setFirstName("Dana")
                .setLastName("Scully")
                .setGender("Female")
                .setPhoneNumberInput("9881234567")
                .clickSubmit()
                .validateResult("Student Name", "Dana Scully")
                .validateResult("Gender", "Female")
                .validateResult("Mobile", "9881234567");
    }

    @Test
    void noFieldHasBeenFilledInTest() {
        registrationPage.openPage()
                .removeUnnecessaryElementsFromPage()
                .clickSubmit()
                .borderColourIsRed(registrationPage.firstNameInput)
                .borderColourIsRed(registrationPage.lastNameInput)
                .borderColourIsRed(registrationPage.phoneNumberInput);
    }
}
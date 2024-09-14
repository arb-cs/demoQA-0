package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestingData;

public class FillStudentRegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestingData testingData = new TestingData();
    String state = testingData.state;
    String city = testingData.getCity(state);

    @Test
    @Tag("demoqa")
    void fillStudentFormTest() {
        registrationPage.openPage()
                        .removeUnnecessaryElementsFromPage()
                        .setFirstName(testingData.firstName)
                        .setLastName(testingData.lastName)
                        .setEmail(testingData.email)
                        .setGender(testingData.sex)
                        .setPhoneNumberInput(testingData.phoneNumber)
                        .setBirthDate(testingData.day, testingData.month, testingData.year)
                        .setSubjects(testingData.subjects)
                        .setHobbies(testingData.hobbies)
                        .setPicture(testingData.picture)
                        .setAddress(testingData.address)
                        .setState(testingData.state)
                        .setCity(city)
                        .clickSubmit()
                        .validateResult("Student Name", testingData.firstName + " " + testingData.lastName)
                        .validateResult("Student Email", testingData.email)
                        .validateResult("Gender", testingData.sex)
                        .validateResult("Mobile", testingData.phoneNumber)
                        .validateResult("Date of Birth", testingData.day + " " + testingData.month + "," + testingData.year)
                        .validateResult("Subjects", testingData.subjects)
                        .validateResult("Hobbies", testingData.hobbies)
                        .validateResult("Picture", testingData.picture)
                        .validateResult("Address", testingData.address)
                        .validateResult("State and City", state + " " + city);
    }

    @Test
    @Tag("demoqa")
    void fillOnlyRequiredFieldsTest() {
        registrationPage.openPage()
                .removeUnnecessaryElementsFromPage()
                .setFirstName(testingData.firstName)
                .setLastName(testingData.lastName)
                .setGender(testingData.sex)
                .setPhoneNumberInput(testingData.phoneNumber)
                .clickSubmit()
                .validateResult("Student Name", testingData.firstName + " " + testingData.lastName)
                .validateResult("Gender", testingData.sex)
                .validateResult("Mobile", testingData.phoneNumber);
    }

    @Test
    @Tag("demoqa")
    void noFieldHasBeenFilledInTest() {
        registrationPage.openPage()
                .removeUnnecessaryElementsFromPage()
                .clickSubmit()
                .borderColourIsRed(registrationPage.firstNameInput)
                .borderColourIsRed(registrationPage.lastNameInput)
                .borderColourIsRed(registrationPage.phoneNumberInput);
    }
}
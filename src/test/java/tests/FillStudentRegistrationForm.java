package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillStudentRegistrationForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillStudentFormTest() {
        registrationPage.openPage()
                        .setFirstName("Dana")
                        .setLastName("Scully")
                        .setEmail("dana_scully@xfiles.com")
                        .setGender("Female")
                        .setPhoneNumber("9881234567")
                        .setBirthDate("12", "December", "1990");

        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("s3e20.png");
        $("#currentAddress").setValue("We're somewhere in the woods chasing aliens.");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        // Validate student's input.
        $(".table").shouldHave(text("Student Name Dana Scully"));
        $(".table").shouldHave(text("Student Email dana_scully@xfiles.com"));
        $(".table").shouldHave(text("Gender Female"));
        $(".table").shouldHave(text("Mobile 9881234567"));
        $(".table").shouldHave(text("Date of Birth 12 December,1990"));
        $(".table").shouldHave(text("Subjects Arts"));
        $(".table").shouldHave(text("Hobbies Reading"));
        $(".table").shouldHave(text("Picture s3e20.png"));
        $(".table").shouldHave(text("We're somewhere in the woods chasing aliens."));
        $(".table").shouldHave(text("State and City NCR Delhi"));
    }
}
package demoQATests;

import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class fillStudentRegistrationFormTestCase {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillStudentForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Fill in the fields for the registration form.
        $("#firstName").setValue("Dana");
        $("#lastName").setValue("Scully");
        $("#userEmail").setValue("dana_scully@xfiles.com");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("9881234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--012:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/s3e20.png"));
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
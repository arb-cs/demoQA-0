package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends Base {

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumber = $("userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("hobbiesWrapper"),
            uploadPicture = $("uploadPicture"),
            currentAddressInput = $("currentAddress");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail (String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String sex) {
        genderWrapper.$(byText(sex)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String number) {
        phoneNumber.setValue(number);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
}
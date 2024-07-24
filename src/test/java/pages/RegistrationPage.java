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
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            setState = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            selectCity = $("#stateCity-wrapper"),
            submitButton = $("#submit");


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

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage clickOnSelectStateList() {
        stateInput.click();
        return this;
    }

    public RegistrationPage setState(String state) {
        setState.$(byText(state)).click();
        return this;
    }

    public RegistrationPage clickOnSelectCityList() {
        cityInput.click();
        return this;
    }

    public  RegistrationPage setCity(String city) {
        selectCity.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

}
package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    @Step("Open the student registration form.")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeUnnecessaryElementsFromPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$(\"[id*='google_ads_iframe']\").remove()");
        return this;
    }

    public final SelenideElement firstNameInput = $("#firstName");
    public final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement selectGender = $("#genterWrapper");
    public final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement selectHobbies = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement setState = $("#stateCity-wrapper");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement selectCity = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    @Step("Set a first name.")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Set a last name.")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Set an email.")
    public RegistrationPage setEmail (String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Set a gender.")
    public RegistrationPage setGender(String sex) {
        selectGender.$(byText(sex)).click();
        return this;
    }

    @Step("Set a phone number.")
    public RegistrationPage setPhoneNumberInput(String number) {
        phoneNumberInput.setValue(number);
        return this;
    }

    @Step("Set a birthdate.")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Set subjects.")
    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Set hobbies.")
    public RegistrationPage setHobbies(String hobbies) {
        selectHobbies.$(byText(hobbies)).click();
        return this;
    }

    @Step("Set a picture.")
    public RegistrationPage setPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    @Step("Set an address")
    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Set a state.")
    public RegistrationPage setState(String state) {
        stateInput.click();
        setState.$(byText(state)).click();
        return this;
    }

    @Step("Set a city.")
    public  RegistrationPage setCity(String city) {
        cityInput.click();
        selectCity.$(byText(city)).click();
        return this;
    }

    @Step("Click the submit button.")
    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Validate the result.")
    public RegistrationPage validateResult(String element, String value) {
        tableComponent.checkResult(element, value);
        return this;
    }

    @Step("The border colours are red when a user did not fill the required fields.")
    public RegistrationPage borderColourIsRed(SelenideElement element) {
        String redColour = "rgb(220, 53, 69)";
        element.shouldHave(Condition.cssValue("border-color", redColour));
        return this;
    }
}
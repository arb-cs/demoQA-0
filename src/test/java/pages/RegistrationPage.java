package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeUnnecessaryElementsFromPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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
        selectGender.$(byText(sex)).click();
        return this;
    }

    public RegistrationPage setPhoneNumberInput(String number) {
        phoneNumberInput.setValue(number);
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
        selectHobbies.$(byText(hobbies)).click();
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

    public RegistrationPage setState(String state) {
        stateInput.click();
        setState.$(byText(state)).click();
        return this;
    }

    public  RegistrationPage setCity(String city) {
        cityInput.click();
        selectCity.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage validateResult(String element, String value) {
        tableComponent.checkResult(element, value);
        return this;
    }

    public RegistrationPage borderColourIsRed(SelenideElement element) {
        String redColour = "rgb(220, 53, 69)";
        element.shouldHave(Condition.cssValue("border-color", redColour));
        return this;
    }
}
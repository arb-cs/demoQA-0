package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Base {
    public Base removeUnnecessaryElementsFromPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
}

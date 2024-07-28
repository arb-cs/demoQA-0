package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class TableComponent {
    private final SelenideElement resultTable = $(".table");

    public TableComponent checkResult(String element, String value) {
        resultTable.shouldHave(text(element + " " + value));
        return this;
    }
}
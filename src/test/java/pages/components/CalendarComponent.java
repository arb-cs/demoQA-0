package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {

       day = String.format("%03d", Integer.parseInt(day));

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)", day)).click();
    }
}
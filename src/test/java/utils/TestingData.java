package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestingData {

    Faker faker = new Faker(Locale.ENGLISH);
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String sex = faker.options().option("Male", "Female", "Other");
    public Date birthday = faker.date().birthday();
    public String phoneNumber = faker.number().digits(10);
    public String subjects = faker.options()
            .option("Maths", "Physics", "Chemistry", "Computer Science", "Economics", "Arts", "Social Studies", "History", "Civics");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String picture = "s3e20.png";
    public String address = faker.address().streetAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String getCity(String state) {
        if ("NCR".equals(state)) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(state)) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if ("Haryana".equals(state)) {
            return faker.options().option("Karnal", "Panipat");
        } else if ("Rajasthan".equals(state)) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return state;
    }

    public String day() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(birthday);
    }

    public String month() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return monthFormat.format(birthday);
    }

    public String year() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return yearFormat.format(birthday);
    }


}
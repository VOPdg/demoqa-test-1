package hansecom;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    void successTest() throws InterruptedException {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Veronika");
        $("#lastName").setValue("Padgok");
        $("#userEmail").setValue("testForm@mailinator.com");
       // $("#gender-radio-3").doubleClick();// bad variant
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("1234543456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--018").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for= hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("text.txt");
        $("#currentAddress").setValue("Minsk, 220117");
        $("#state").scrollTo().click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();
        SelenideElement table = $(".modal-body").$("table").$("tbody");
        Assertions.assertEquals("Veronika Padgok", table.$("tr:nth-child(1)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("testForm@mailinator.com", table.$("tr:nth-child(2)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Female", table.$("tr:nth-child(3)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("1234543456", table.$("tr:nth-child(4)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("18 November,1984", table.$("tr:nth-child(5)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Maths", table.$("tr:nth-child(6)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Reading", table.$("tr:nth-child(7)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("text.txt", table.$("tr:nth-child(8)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("Minsk, 220117", table.$("tr:nth-child(9)").$("td:nth-child(2)").getText());
        Assertions.assertEquals("NCR Delhi", table.$("tr:nth-child(10)").$("td:nth-child(2)").getText());
        // Assertions.assertEquals("Veronika Padgok", $x("//*[@class=\"modal-body\"]//table/tbody/tr[1]/td[last()]").text());

    }
}

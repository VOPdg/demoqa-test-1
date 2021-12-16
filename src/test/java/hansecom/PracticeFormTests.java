package hansecom;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @Test
    void successTest() throws InterruptedException {
      open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Veronika");
        $("#lastName").setValue("Padgok");
        $("#userEmail").setValue("testForm@mailinator.com");
        $("#gender-radio-2").doubleClick();
        $("#userNumber").setValue("1234543456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--018").click();
    }
}

package Test;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Junit5Test {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 55000;
    }

    @DisplayName("Тестирование поиска билетов на сайте Aviasales")
    @Test()
    void aviasalesSearchTicketsTest() {
//        Предусловия:
        open("https://www.aviasales.ru/");
//        Шаги:
        $("#origin").click();
        $("#origin").sendKeys(Keys.BACK_SPACE);
        $("#origin").setValue("Сочи");
        $("#destination").setValue("Краснодар");
        $("[data-test-id=departure-date-field]").shouldBe(visible).click();
        $(".calendar-caption__select").click();
        $(".calendar-caption__select").selectOption("Июль");
        $(".calendar-caption__select").click();
        $(".calendar__weeks-body").$(byText("7")).click();
        $("[data-test-id=no-return-ticket]").click();
        $(".of_input_checkbox__label").click();
        $("[data-test-id=form-submit]").click();
//        Ожидаемый результат:
        $("[data-test-id=origin-endpoint]").shouldHave(text("Сочи"));
        $("[data-test-id=origin-endpoint]").shouldHave(text("7 июл 2022, чт"));
        $("[data-test-id=destination-endpoint]").shouldHave(text("Краснодар"));



    }
}

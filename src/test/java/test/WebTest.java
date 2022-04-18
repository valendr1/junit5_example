package test;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.FillForm;

import static java.lang.String.format;

public class WebTest {
    FillForm fillForm = new FillForm();
    String monthOfDeparture = "Июль";
    String dayOfDeparture = "7";
    //for asserts
    String checkMonth = "Июл";
    String checkYear = "2022";
    String dateOfDeparture = format("%s %s %s", dayOfDeparture, checkMonth, checkYear);



    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 55000;
    }

    @AfterEach
    void close() {
        Selenide.closeWebDriver();
    }

    @CsvSource(value = {
            "Сочи, Краснодар",
            "Москва, Омск"
    })

    @DisplayName("Тестирование поиска билетов на сайте Aviasales")
    @ParameterizedTest(name = "Проверка поиска билетов из г.{0} в г.{1}")
    void aviasalesSearchTicketsTest(String cityDepartureChoose, String cityDestinationChoose) {
//        Предусловия:
        Selenide.open("https://www.aviasales.ru/");
//        Шаги:
        fillForm.setCityDeparture(cityDepartureChoose)
                .setCityDestination(cityDestinationChoose)
                .setDayOfDeparture(monthOfDeparture, dayOfDeparture)
                .setNoReturnTicket()
                .notOpenBooking()
                .submitForm();
//        Ожидаемый результат:
        fillForm.checkCityOfDeparture(cityDepartureChoose)
                .checkDate(dateOfDeparture)
                .checkCityOfDestination(cityDestinationChoose);
    }


}

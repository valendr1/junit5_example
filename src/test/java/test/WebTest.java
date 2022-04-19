package test;

import com.codeborne.selenide.*;
import domain.MenuItem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import pages.FillFormAviasales;
import pages.SearchOzon;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class WebTest {
    FillFormAviasales fillFormAviasales = new FillFormAviasales();
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
        open("https://www.aviasales.ru/");
//        Шаги:
        fillFormAviasales.setCityDeparture(cityDepartureChoose)
                .setCityDestination(cityDestinationChoose)
                .setDayOfDeparture(monthOfDeparture, dayOfDeparture)
                .setNoReturnTicket()
                .notOpenBooking()
                .submitForm();
//        Ожидаемый результат:
        fillFormAviasales.checkCityOfDeparture(cityDepartureChoose)
                .checkDate(dateOfDeparture)
                .checkCityOfDestination(cityDestinationChoose);
    }

    SearchOzon searchOzon = new SearchOzon();

    @DisplayName("Тестирование при помощи ENUM")
    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Проверка наличия телевизоров {0} в наличии на OZON")
    void ozonSimpleTest(MenuItem testData) {
        //        Предусловия:
        open("https://www.ozon.ru/");
        //        Шаги:
        searchOzon.openCatalog()
                .openElectronic()
                .openTelevisorsTab();

//       // Ожидаемый результат:
        $$(".io3")
                .find(Condition.text(testData.translationName))
                .click();
    }

    //Проверка аннотации Disabled
    @Disabled
    @DisplayName("Тестирование поиска Wildberries")
    @Test
    void ozonSecondTest() {
        //        Предусловия:
        open("https://www.wildberries.ru");
    }

}

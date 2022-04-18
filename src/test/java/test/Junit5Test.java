package test;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FillForm;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class Junit5Test {
    FillForm fillForm = new FillForm();
    String cityDepartureChoose = "Сочи";
    String cityDestinationChoose = "Краснодар";
    String monthOfDeparture = "Июль";
    String dayOfDeparture = "7";
    //for asserts
    String checkMonth = "Июл";
    String checkYear = "2022";
    String dateOfDeparture = format("%s %s %s", dayOfDeparture, checkMonth, checkYear);



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

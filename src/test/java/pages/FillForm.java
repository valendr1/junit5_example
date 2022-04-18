package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FillForm {

    //locators
    SelenideElement cityDeparture = $("#origin");
    SelenideElement cityDestination = $("#destination");
    SelenideElement openCalendar = $(".trip-duration__input-wrapper.--departure");
    SelenideElement setMonth = $(".calendar-caption__select");
    SelenideElement setDay = $(".calendar__weeks-body");
    SelenideElement setNoReturnTickets = $("[data-test-id=no-return-ticket]");
    SelenideElement setNotOpenBooking = $(".of_input_checkbox__label");
    SelenideElement submitForm = $("[data-test-id=form-submit]");
    SelenideElement checkDeparture = $("[data-test-id=origin-endpoint]");
    SelenideElement checkDestination = $("[data-test-id=destination-endpoint]");


    //actions
    public FillForm setCityDeparture(String cityDepartureChoose) {
        cityDeparture.click();
        cityDeparture.sendKeys(Keys.BACK_SPACE);
        cityDeparture.setValue(cityDepartureChoose);
        return this;
    }

    public FillForm setCityDestination(String cityDestinationChoose) {
        cityDestination.setValue(cityDestinationChoose);
        return this;

    }

    public FillForm setDayOfDeparture(String monthOfDeparture, String dayOfDeparture) {
        Selenide.sleep(3000);
        openCalendar.shouldBe(visible).click();
        setMonth.click();
        setMonth.selectOption(monthOfDeparture);
        setMonth.click();
        setDay.$(byText(dayOfDeparture)).click();
        return this;
    }

    public FillForm setNoReturnTicket() {
        setNoReturnTickets.click();
        return this;
    }

    public FillForm notOpenBooking() {
        setNotOpenBooking.click();
        return this;
    }

    public FillForm submitForm() {
        submitForm.click();
        return this;
    }

    //asserts
    public FillForm checkCityOfDeparture (String checkCityOfDeparture) {
        checkDeparture.shouldHave(text(checkCityOfDeparture));
        return this;
    }

    public FillForm checkDate (String date){
        checkDeparture.shouldHave(text(date));
        return this;
    }

    public FillForm checkCityOfDestination (String checkCityOfDestination) {
        checkDestination.shouldHave(text(checkCityOfDestination));
        return this;
    }
}

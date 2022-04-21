package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchWildberries {
    //locators
    SelenideElement searhProduct = $("#searchInput");
    SelenideElement checkSearch = $(".searching-results__title");

    //actions
    public SearchWildberries inputSearch(String product) {
        searhProduct.click();
        searhProduct.setValue(product);
        searhProduct.pressEnter();
        return this;
    }
    //asserts
    public SearchWildberries checkResultsWB(String product){
        checkSearch.shouldHave(text(product));
        return this;
    }


}

package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchOzon {
    //locators
    SelenideElement chooseCatalog = $(".ui-b4.ui-b6");
    SelenideElement chooseElectronic = $(".g3s.e4c.c5e.c6e");
    SelenideElement chooseTelevisors = $(".d8c");
    ElementsCollection checkResults = $$(".io3");


    //actions
    public SearchOzon openCatalog(){
        chooseCatalog.click();
        return this;
    }

    public SearchOzon openElectronic(){
        chooseElectronic.click();
        return this;
    }

    public SearchOzon openTelevisorsTab(){
        chooseTelevisors.$(byText("Телевизоры")).click();
        return this;
    }

}


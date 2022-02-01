package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    SelenideElement loginlink = $("#login_link");

    public void clickOnLoginLink() {
        loginlink.shouldBe(Condition.visible).click();
    }
    public void messageIsDisplayed(String message) {
        $(byText(message)).shouldBe(Condition.visible);
    }

    public void isItHomePage() {
        Selenide.title().equals("http://selenium1py.pythonanywhere.com/en-gb/");
    }

    public void selectMenu(String value) {
        $(byXpath("//a[contains(text(),'"+ value +"')]")).click();
    }

}

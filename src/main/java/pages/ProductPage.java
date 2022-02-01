package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {
    public void productInformationIsDisplayed() {
        $(byText("Product Information")).shouldBe(Condition.visible);
    }

    public String getBookName() {
        return $(".product_main h1").text();
    }

    public void viewBasket() {

        $(byText("View basket")).shouldBe(Condition.visible).click();
    }

    public void addToBasket() {
        $(byText("Add to basket")).click();
    }

    public String getBookPrice() {
        return $(By.xpath("//p[contains(text(),'£9.99')]")).text();
    }

    public void addToBasketFromProductPage() {
        $(byText("Add to basket")).click();
    }

    public void checkoutNowIsDisplayed() {

        $(byText("Checkout now")).shouldBe(Condition.visible);
    }
}

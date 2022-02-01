package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    ElementsCollection listOfBooks = $$(".product_pod img");

    public void selectBookByIndex(int i) {
        listOfBooks.get(i).click();

    }

    public void addToBasketFromCat() {
        $(byText("Add to basket")).click();
    }

    public void viewBasketIsDisplayed() {

        $(byText("View basket")).shouldBe(Condition.visible);
    }
}

package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    public String getBookNameInBasket() {
       return $("div h3 a").text();
    }
    public String getBookPriceInBasket(){
        return $(By.xpath("//*[@id=\"basket_formset\"]/div/div/div[4]/p")).text();
    }
}
package tests;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CatalogPage;
import pages.HomePage;
import pages.ProductPage;


public class BasketTests extends BaseTest {
    HomePage homePage;
    BasketPage basketPage;
    CatalogPage catalogPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        homePage = new HomePage();
        basketPage = new BasketPage();
        catalogPage = new CatalogPage();
        productPage = new ProductPage();
    }

    @Test
    public void nameValidation() throws InterruptedException {
        homePage.selectMenu("Books");
        catalogPage.selectBookByIndex(0);
        Thread.sleep(1000);
        productPage.productInformationIsDisplayed();
        String name = productPage.getBookName();
        productPage.addToBasket();
        productPage.viewBasket();
        String bookName = basketPage.getBookNameInBasket();
        Assert.assertEquals(name, bookName); //сравнит два названия
    }

    @Test
    public void priceValidation() throws InterruptedException {
        homePage.selectMenu("Books");
        catalogPage.selectBookByIndex(0);
        Thread.sleep(1000);
        productPage.productInformationIsDisplayed();
        String price = productPage.getBookPrice();
        productPage.addToBasket();
        productPage.viewBasket();
        String price2 = basketPage.getBookPriceInBasket();
        Assert.assertEquals(price, price2); //сравнит двe цены
    }

    @Test
    public void addToBasketFromCatalog() {
        homePage.selectMenu("Books");
        catalogPage.selectBookByIndex(0);
        catalogPage.addToBasketFromCat();
        catalogPage.viewBasketIsDisplayed();
    }
        @Test
        public void addToBasketFromProductPage() {
            homePage.selectMenu("Books");
            catalogPage.selectBookByIndex(0);
            productPage.addToBasketFromProductPage();
            Selenide.screenshot("screenshot_001"); //сделает скриншот
            productPage.checkoutNowIsDisplayed();
    }
}

package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.util.DataProviders;

public class LoginTests extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    String email = "olgatest01@gmail.com";
    String password = "Letmein123$";
    String emailInvalid = "olgatest01@mail.com";
    String passwordInvalid = "etmein123$";

    @BeforeMethod(alwaysRun = true) //запускается всегда
    public void Test(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(priority = 1, groups = "positive")
//    @Parameters({"email", "password"})
    public void loginPositiveTest(){
        homePage.clickOnLoginLink();
        loginPage.loginFormIsVisible();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        homePage.isItHomePage();
        homePage.messageIsDisplayed("Welcome back");
    }

    @Test(priority = 2, groups = {"negative"}, dataProviderClass = DataProviders.class, dataProvider = "loginNegativeUsingFile")
    public void loginNegativeTest(String emailInvalid, String passwordInvalid){
        homePage.clickOnLoginLink();
        loginPage.loginFormIsVisible();
        loginPage.fillEmail(emailInvalid);
        loginPage.fillPassword(passwordInvalid);
        loginPage.clickLogin();
        loginPage.isItLoginPage();
        loginPage.messageIsDisplayed("Oops! We found some errors");

    }


}
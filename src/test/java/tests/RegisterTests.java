package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.util.Random;
public class RegisterTests extends BaseTest{
    HomePage homePage;
    RegisterPage registerPage;
    String email = "olgatest" + randomNumeric(3) + "@gmail.com";
    String password = "Letmein123$";


/*public class RegisterTests extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    String email = "olgatest011@gmail.com";
    String password = "Letmein123$";*/

    @BeforeMethod
    public void Test() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test
    public void registerPositiveTest() {
        homePage.clickOnLoginLink();
        registerPage.registerFormIsVisible();
        registerPage.fillRegistrationEmail(email);
        registerPage.fillRegistrationPassword(password);
        registerPage.fillConfirmPassword(password);
        registerPage.clickRegister();
        Configuration.timeout = 10000;
        registerPage.viewMessage();
        homePage.isItHomePage();
        homePage.messageIsDisplayed("Thanks for registering!");
    }

    public static String randomNumeric(int strLen) { // метод генерирует рандомное число для емейла
        String numStr = "";
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        numStr += i1;

        for (int i = 0; i < strLen - 1; i++) {
            int num = random.nextInt(10);
            numStr += num;
        }

        return numStr;
    }

}

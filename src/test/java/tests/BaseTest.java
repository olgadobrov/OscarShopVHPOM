package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void initTest() {
        Configuration.browserSize = "1920x1080";
        open("http://selenium1py.pythonanywhere.com/en-gb/");
        Configuration.timeout = 10000;
    }


    @AfterMethod(alwaysRun = true)
    public void closeTest(ITestResult result, Method method) {
        //Create new file name for screenshot
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curDate = formatter.format(date);
        String filePath = "screenshots/screenshot_" + curDate;
        if (result.isSuccess()) {
            Selenide.screenshot(filePath);
        }

        closeWebDriver();
    }
}


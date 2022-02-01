package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement loginForm = $("#login_form");

    public void loginFormIsVisible() {
        loginForm.shouldBe(Condition.visible);
    }

    public void fillEmail(String email) {
        $("#id_login-username").setValue(email);

    }

    public void fillPassword(String password) {
        $("#id_login-password").setValue(password);

    }

    public void clickLogin() {
        $("[name=\"login_submit\"]").click();
    }

    public void messageIsDisplayed(String s) {
//        $(byText(s)).shouldBe(Condition.visible);
        $(".alert strong").shouldBe(Condition.visible).shouldHave(Condition.text(s));
    }

    public void isItLoginPage() {
        Selenide.title().equals("http://selenium1py.pythonanywhere.com/en-gb/accounts/login/");
    }

}
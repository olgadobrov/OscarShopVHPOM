package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    SelenideElement registerForm = $("#register_form");
    SelenideElement message = $("#messages");

    public void registerFormIsVisible() {
        registerForm.shouldBe(Condition.visible);
    }

    public void fillRegistrationEmail(String email) {
        $("#id_registration-email").setValue(email);

    }

    public void fillRegistrationPassword(String password) {
        $("#id_registration-password1").setValue(password);

    }

    public void fillConfirmPassword(String password) {
        $("#id_registration-password2").setValue(password);

    }

    public void clickRegister() {
        $("[name=\"registration_submit\"]").click();
    }

    public void viewMessage(){
        message.shouldHave(Condition.text("Thanks for registering!"));
    }
}

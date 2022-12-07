package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String titleText = "Student Registration Form";

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void setFirstName(String value){
        $("#firstName").setValue(value);
    }

    public void setLastName(){
        $("#lastName").setValue("Barabanov");
    }
}

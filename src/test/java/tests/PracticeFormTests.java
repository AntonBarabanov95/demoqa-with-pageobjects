package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillPracticeFormTest() {
        String firstName = "Anton";

        new RegistrationPage().openPage();

        new RegistrationPage().setFirstName(firstName);
        new RegistrationPage().setLastName();

        $("#userEmail").setValue("anton.barabanov95@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("88005553535");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--021").click();

        $("#hobbiesWrapper").$(byText("Sports")).click();


        File pepega = new File("src/test/resources/pepega.png");
        $("#uploadPicture").uploadFile(pepega);

        $("#currentAddress").setValue("Улица Пушкина дом Калатушкина");

        //У меня просто у ноута экран маленький, приходится скроллить вниз (пока я не удалил footer)
        //$("#submit").scrollIntoView(false);
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Anton Barabanov"), text("anton.barabanov95@gmail.com"), text("Male"),
                text("8800555353"), text("21 July,1995"), text("Sports"), text("pepega.png"), text("Улица Пушкина дом Калатушкина"),
                text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}
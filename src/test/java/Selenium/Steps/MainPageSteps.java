package Selenium.Steps;

import Selenium.Pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {

    MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public boolean goToResendPage() {

        mainPage.pressGetStartedButton();
        mainPage.inputEmailFormText();
        mainPage.pressCreateWrikeAcountButton();
       return mainPage.isItResendPage();
    }
}

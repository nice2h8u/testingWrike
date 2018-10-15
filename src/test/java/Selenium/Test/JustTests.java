package Selenium.Test;

import Selenium.Pages.MainPage;
import Selenium.Steps.MainPageSteps;
import Selenium.Steps.ResendPageSteps;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JustTests {

    private WebDriver driver;
    MainPageSteps mainPageSteps;
    ResendPageSteps resendPageSteps;


    @Before
    public void inicialization() {
        driver = new FirefoxDriver();
       // driver.manage().window().maximize();
        mainPageSteps = new MainPageSteps(driver);
        resendPageSteps = new ResendPageSteps(driver);
    }


    @Test
    public void AllTests(){
        assertTrue( mainPageSteps.goToResendPage());
        assertTrue(resendPageSteps.fillQaAndCheck());
        assertTrue(resendPageSteps.resendAndCheckEmailVer());
        assertTrue(resendPageSteps.checkTwitterImage());
    }


}

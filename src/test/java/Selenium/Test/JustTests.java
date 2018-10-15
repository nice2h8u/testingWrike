package Selenium.Test;


import Selenium.Steps.MainPageSteps;
import Selenium.Steps.ResendPageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class JustTests {

    private WebDriver driver;
    MainPageSteps mainPageSteps;
    ResendPageSteps resendPageSteps;


    @Before
    public void inicialization() {
        driver = new FirefoxDriver();
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test
    public void AllTests(){
        mainPageSteps = new MainPageSteps(driver);
        assertTrue( mainPageSteps.goToResendPage());

        resendPageSteps = new ResendPageSteps(driver);
        assertTrue(resendPageSteps.fillQaAndCheck());
        assertTrue(resendPageSteps.resendAndCheckEmailVer());
        assertTrue(resendPageSteps.checkTwitterButtonExists());
        assertTrue(resendPageSteps.checkTwitterImageUrl());
        assertTrue(resendPageSteps.checkTwitterImageAdress());
    }
    @After
    public void end(){
        driver.quit();
    }

}

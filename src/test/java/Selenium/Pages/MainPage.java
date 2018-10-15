package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class MainPage {

    private String mainPageUrl;

    private String surfToResendPageUrl;

    private WebDriver driver;

    private WebElement getStartedButton;

    private WebElement inputEmailForm;

    private WebElement createWrikeAcountButton;


    public MainPage(WebDriver driver) {

        this.driver = driver;
        mainPageUrl = "https://www.wrike.com/";
        surfToResendPageUrl = "https://www.wrike.com/resend/";
        getStartedButton = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button"));
        inputEmailForm = driver.findElement(By.xpath("/html/body/div[4]/div/form/label[1]/input"));
        createWrikeAcountButton = driver.findElement(By.xpath("/html/body/div[4]/div/form/label[2]/button"));

    }

    public void goToMainPage(){
        driver.get("https://www.wrike.com/resend/");
    }

    public void pressGetStartedButton() {
        getStartedButton.click();
    }

    public void inputEmailFormText() {

        String email = "";
        for (int i = 1 + (int) (Math.random() * 9); i > 0; i--)
            email = email + (char) (97 + (int) (Math.random() * 25));

        email = email + "+wpt@wriketask.qaa";

        inputEmailForm.sendKeys(email);
    }

    public void pressCreateWrikeAcountButton() {
        createWrikeAcountButton.click();
    }

    public boolean isItResendPage() {

        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Thank you for choosing Wrike!"));

        return driver.getCurrentUrl().contains("https://www.wrike.com/resend/");
    }


}

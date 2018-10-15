package Selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WrikeTest {

    private WebDriver driver;

    @Before
    public void inicialization() {

        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        // driver.manage().window().setSize(new Dimension(1440, 900));

    }

    @Test
    public void testMainPage() {

        driver.get("https://www.wrike.com/");
        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")).click();
        String email = "";
        for (int i = 1 + (int) (Math.random() * 9); i > 0; i--)
            email = email + (char) (97 + (int) (Math.random() * 25));

        email = email + "+wpt@wriketask.qaa";

        driver.findElement(By.xpath("/html/body/div[4]/div/form/label[1]/input")).sendKeys(email);

        driver.manage().timeouts().setScriptTimeout(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        driver.findElement(By.xpath("/html/body/div[4]/div/form/label[2]/button")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Thank you for choosing Wrike!"));

        assertEquals("https://www.wrike.com/resend/", driver.getCurrentUrl());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }

        //close the banner
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("/html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div")).click();
        //return to the main page
        driver.switchTo().defaultContent();
        //answers
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[1]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[1]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input")).sendKeys("blabla");
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")).submit();
        //check that the answers were submit
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")));
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")).isDisplayed());
        //send email varification
        driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")).click();
        //check that the email varification was send
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")));
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")).isDisplayed());

        WebElement twitterButton = driver.findElement(By.cssSelector
                (".wg-footer__group.wg-footer__group--social")).findElements(By.cssSelector(".wg-footer__social-link")).get(0);

        // check if it exist
        assertTrue(twitterButton.isDisplayed());

        // check if it leads to the correct url
        assertEquals("https://twitter.com/wrike", twitterButton.getAttribute("href"));

        // check if it contains right icon
        String imageAddress = twitterButton.findElement(By.tagName("use")).getAttribute("xlink:href");
        assertEquals("/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter", imageAddress);
    }


}

package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResendPage {

    private WebDriver driver;

    private String resendPageUrl;

    private String twitterImageUrl;

    private String twitterImageAdress;
    @FindBy (xpath = "/html/body/c-wiz/div/div/div[2]/div[4]/span[1]/div")
    private WebElement noButtonInFrame;

    @FindBy(css = ".switch__button")
    List<WebElement> buttonsFromAnswerArea;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")
    private WebElement submitAnswersButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")
    private WebElement sendEmailVerificationButton;


    private WebElement twitterButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span/input")
    private WebElement hidenInputArea;


    public ResendPage(WebDriver driver) {


        this.driver = driver;
        resendPageUrl = "https://www.wrike.com/resend/";
        twitterImageAdress="/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v1#twitter";
        twitterImageUrl = "https://twitter.com/wrike";
        PageFactory.initElements(driver, this);
        twitterButton = driver.findElement(By.cssSelector
                (".wg-footer__group.wg-footer__group--social")).findElements(By.cssSelector(".wg-footer__social-link")).get(0);


    }



    public void closeFrame() {
        //wait until the frame become visible
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the banner
        driver.switchTo().frame(1);
        noButtonInFrame.click();
        //return to the main page
        driver.switchTo().defaultContent();

        //inicialize twitter button

    }

    public void inicialize(){

    }

    public void randomButtonsForAnswersArea() {

        int firstArea = (int) (Math.random() * 1);
        int secondArea = 2 + (int) (Math.random() * 4);
        int thirdArea = 7 + (int) (Math.random() * 2);
        buttonsFromAnswerArea.get(firstArea).click();
        buttonsFromAnswerArea.get(secondArea).click();
        buttonsFromAnswerArea.get(thirdArea).click();
        if (thirdArea == 9)
            hidenInputArea.sendKeys("blabla");

    }

    public void submitResults() {
        submitAnswersButton.submit();
    }

    public boolean isSubmittedResults() {

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(submitAnswersButton));
        return (submitAnswersButton.isDisplayed());
    }

    public void sendEmailVerification() {
        sendEmailVerificationButton.click();
    }

    public boolean isSendEmailVerification() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sendEmailVerificationButton));
        return (sendEmailVerificationButton.isDisplayed());
    }

    public boolean isTwitterButtonExists() {

        return twitterButton.isDisplayed();
    }
    public  boolean isTwitterImageUrlRight(){
        return twitterButton.getAttribute("href").contains(twitterImageUrl);
    }
    public boolean isTwitterImageAdressRight()
    {


        return twitterButton.findElement(By.tagName("use")).getAttribute("xlink:href").contains(twitterImageAdress);
    }

}

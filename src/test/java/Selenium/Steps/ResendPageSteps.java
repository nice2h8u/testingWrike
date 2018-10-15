package Selenium.Steps;

import Selenium.Pages.ResendPage;
import org.openqa.selenium.WebDriver;

public class ResendPageSteps {
    ResendPage resendPage;

    public ResendPageSteps(WebDriver driver){
        resendPage = new ResendPage(driver);
    }

    public boolean fillQaAndCheck(){

        resendPage.closeFrame();
        resendPage.randomButtonsForAnswersArea();
        resendPage.submitResults();
        return  resendPage.isSubmittedResults();
    }

    public boolean resendAndCheckEmailVer(){
        resendPage.sendEmailVerification();
        return resendPage.isSendEmailVerification();
    }

    public boolean checkTwitterButtonExists(){

        return resendPage.isTwitterButtonExists();
    }

    public boolean checkTwitterImageAdress(){
        return resendPage.isTwitterImageAdressRight();
    }

    public boolean checkTwitterImageUrl(){

        return  resendPage.isTwitterImageUrlRight();
    }
}

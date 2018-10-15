package Selenium.Steps;

import Selenium.Pages.ResendPage;
import org.openqa.selenium.WebDriver;

public class ResendPageSteps {
    ResendPage resendPage;

    public ResendPageSteps(WebDriver driver){
        resendPage = new ResendPage(driver);
    }

    public boolean fillQaAndCheck(){
        resendPage.goToResendPage();
        resendPage.closeFrame();
        resendPage.randomButtonsForAnswersArea();
        resendPage.submitResults();
        return  resendPage.isSubmittedResults();
    }

    public boolean resendAndCheckEmailVer(){
        resendPage.sendEmailVerification();
        return resendPage.isSendEmailVerification();
    }

    public boolean checkTwitterImage(){

        return (resendPage.isTwitterButtonExists() && resendPage.isTwitterImageUrlRight() && resendPage.isTwitterImageAdressRight());
    }
}

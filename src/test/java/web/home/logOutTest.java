package web.home;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.base.BaseTest;

import static web.constants.Constant.CheckingNames.USER_MAIL;
import static web.constants.Constant.CheckingNames.USER_PASSWORD;
import static web.constants.Constant.TimeoutVariable.EXPLICIT_SHORT_WAIT;

public class logOutTest extends BaseTest {
    private String userMai = USER_MAIL;
    private String userPassword = USER_PASSWORD;

    @BeforeMethod
    public void logIn(){
        if (homePage.signedOut()) {
            homePage.signInBtnClick();
            authenticationPage
                    .registeredMailFieldInput(userMai)
                    .passwordFieldInput(userPassword)
                    .signInButtonClick()
                    .goHome();
        }
    }

    @Test(priority = 0)
    public void logOutUI(){
        printTestStart();
        homePage.signOutBtnClick();
        Assert.assertTrue(homePage.waitTillSignOutBtnDisappear(EXPLICIT_SHORT_WAIT));
        System.out.println("OK - Log Out is complete ");
        printTestFinish();
    }

    @Test(priority = 1)
    public void logOutRef(){
        printTestStart();

        basePage.open("http://automationpractice.com/index.php?mylogout=");
        Assert.assertTrue(homePage.waitTillSignOutBtnDisappear(EXPLICIT_SHORT_WAIT));
        System.out.println("OK - Log Out is complete ");

        printTestFinish();
    }
}

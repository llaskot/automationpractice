package web.home;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.base.BaseTest;

import static web.constants.Constant.CheckingNames.USER_MAIL;
import static web.constants.Constant.CheckingNames.USER_PASSWORD;

public class logOutTest extends BaseTest {
    private String userMai = USER_MAIL;
    private String userPassword = USER_PASSWORD;

    @BeforeMethod
    public void ligIn(){
        if (homePage.signedOut()) {
            homePage.signInBtnClick();
            authenticationPage
                    .registeredMailFieldInput(userMai)
                    .passwordFieldInput(userPassword)
                    .signInButtonClick()
                    .goHome();
        }
    }

    @Test
    public void logOutUI(){
        printTestStart();
        homePage.signOutBtnClick();
        Assert.assertTrue(homePage.waitTillSignOutBtnDisappear(20));
        System.out.println("OK - Log Out is complete ");
        printTestFinish();
    }
}

package web.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import web.common.CommonActions;
import web.pages.authentication.AuthenticationPage;
import web.pages.base.BasePage;
import web.pages.home.HomePage;

import static web.common.Config.*;
import static web.constants.Constant.Urls.DOMAIN_URL;


public class BaseTest {

    protected static WebDriver driver = CommonActions.createDriver();
    protected Actions builder = new Actions(driver);
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    public void pause(int time)
    {   System.out.println("Pause - "+time/1000+" sek");
        builder.pause(time).perform();
    }



    public void printTestStart(){
        System.out.println("\n"+Thread.currentThread().getStackTrace()[2].getMethodName()+" - starts!\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    public void printTestFinish(){
        System.out.println("\n" + Thread.currentThread().getStackTrace()[2].getMethodName()+" - Finished!\n"+
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }

    @BeforeSuite
    public void getDomainUrl(){
        basePage.open(DOMAIN_URL);
    }

    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAN_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
            System.out.println("AfterTest");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close(){
        if(HOLD_BROWSER_OPEN){
            System.out.println("AfterSuite");
            driver.quit();
        }
    }

}

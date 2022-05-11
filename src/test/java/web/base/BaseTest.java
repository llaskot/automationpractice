package web.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import web.common.CommonActions;
import web.pages.authentication.AuthenticationPage;
import web.pages.base.BasePage;
import web.pages.home.HomePage;

import static web.common.Config.*;
import static web.constants.Constant.Urls.DOMAIN_URL;


public class BaseTest {
    protected static WebDriver driver;
    protected Actions builder;
    protected BasePage basePage;
    protected HomePage homePage;
    protected AuthenticationPage authenticationPage;

    @BeforeTest
    @Parameters({"browserName"})
    public void selectBrowser(@Optional("mozilla") String browserName) {
        PLATFORM_AND_BROWSER = browserName;
        driver = CommonActions.createDriver();
        authenticationPage = new AuthenticationPage(driver);
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
        builder = new Actions(driver);
        basePage.open(DOMAIN_URL);

    }


    public void pause(int time) {
        System.out.println("Pause - " + time / 1000 + " sek");
        builder.pause(time).perform();
    }


    public void printTestStart() {
        System.out.println("\n" + Thread.currentThread().getStackTrace()[2].getMethodName() + " - starts!\n" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    public void printTestFinish() {
        System.out.println("\n" + Thread.currentThread().getStackTrace()[2].getMethodName() + " - Finished!\n" +
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }


    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAN_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
            System.out.println("AfterTest");
            if (HOLD_BROWSER_OPEN) {
                System.out.println("AfterSuite");
                driver.quit();
            }
        }


    }

}

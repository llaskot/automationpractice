package web.pages.base;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static web.constants.Constant.TimeoutVariable.*;
import static web.constants.Constant.Urls.DOMAIN_URL;


public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }


    public void open(String url){
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public List waitElementsAreVisible(List<WebElement> elements){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }


    public WebElement waitElementIsClickable(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void goHome(){
        open(DOMAIN_URL);
    }

//    private final By workSpace = By.id("workspace");
//    public void switchToWorkspace(){
//        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_LONG_WAIT))
//                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(workSpace));
//    }



}

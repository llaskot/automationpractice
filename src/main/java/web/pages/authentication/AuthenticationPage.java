package web.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.base.BasePage;
import web.pages.home.HomePage;

public class AuthenticationPage extends HomePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    private final By registeredMailField = By.id("email");
    public AuthenticationPage registeredMailFieldInput(String userMail){
        driver.findElement(registeredMailField).clear();
        driver.findElement(registeredMailField).sendKeys(userMail);
        return this;
    }

    private final By passwordField = By.id("passwd");
    public AuthenticationPage passwordFieldInput(String pass){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }

    private final By signInButton = By.id("SubmitLogin");
    public AuthenticationPage signInButtonClick(){
        driver.findElement(signInButton).click();
        return this;
    }
}

package web.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.base.BasePage;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*
    Header objects
     */

    private final By signInBtn = By.cssSelector("a[class='login']");
    public void signInBtnClick(){
        driver.findElement(signInBtn).click();
    }


    private static final By userInfo = By.xpath("//div[@class='header-container']//nav//a");
    public boolean signedOut(){
        List<WebElement> userInfoCont = driver.findElements(userInfo);
        if(userInfoCont.size()<3) {
            return true;
        }else return false;
    }

    private final By signOutBtn = By.cssSelector("a[class='logout']");
    public HomePage signOutBtnClick(){
        driver.findElement(signOutBtn).click();
        return this;
    }

    public boolean waitTillSignOutBtnDisappear(int maxTimeSec){
        float waitingTime = 0;
        long startLoadingTime = System.currentTimeMillis();
        boolean result = false;
        String attributeValue = "logout";
        int j;
        do {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(waitingTime <= maxTimeSec*1000) {
                waitingTime = System.currentTimeMillis() - startLoadingTime;
            }else{
                System.out.println("PreLoader is working too long time");
                break;
            }
            List<WebElement> userInfoCont = driver.findElements(userInfo);
            Iterator<WebElement> iter = userInfoCont.iterator();
            while (iter.hasNext()){
                WebElement elem =iter.next();
                String realAttrVal ;
                    realAttrVal = elem.getAttribute("class");
                if(!attributeValue.equals(realAttrVal)){
                    iter.remove();
                }
            }
             if (userInfoCont.size() == 0){
                result = true;
             }
        j = userInfoCont.size();
        }while (j>0);
        return result;
    }
}

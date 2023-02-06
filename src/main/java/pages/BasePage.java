package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static pages.SeleniumCommands.*;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void writeText(By elementBy, String text) {
        sendKeysToElement(driver, elementBy, text);
    }

    public void click(By elementBy){
        clickOnElement(driver, elementBy);
    }

    public void newTabHandle(){
        switchBetweenTabs(driver);
    }
}

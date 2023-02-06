package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By USER_NAME_INPUT_FIELD = By.name("uname");
    private By SUBMIT_BUTTON = By.xpath("//button[contains(text(),'Submit')]");
    private static final String NAME = "Username";


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void enterName() {
        writeText(USER_NAME_INPUT_FIELD,NAME );
    }

    public void clickSubmitButton(){
        click(SUBMIT_BUTTON);
    }

    public void getNewTabHandle(){
        newTabHandle();
    }
}

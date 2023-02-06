package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class NewTabHandletest extends BaseTest {

    private HomePage homePage;
    @BeforeTest
    public void initPages(){
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyNewTabHandle(){
        homePage.clickSubmitButton();
        homePage.getNewTabHandle();
    }

}

package tests;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HandleExceptionTest extends BaseTest {
    private HomePage homePage;
    @BeforeTest
    public void initPages(){
        homePage = new HomePage(driver);
    }

    @Test
    public void loginValidation(){
        homePage.enterName();
    }

}

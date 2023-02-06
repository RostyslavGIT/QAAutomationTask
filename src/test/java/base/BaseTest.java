package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {
   protected WebDriver driver;
    @BeforeTest
    public void launchApplication(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trytestingthis.netlify.app");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}

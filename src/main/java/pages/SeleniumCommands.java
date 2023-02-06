package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.fail;

public class SeleniumCommands {
    private static final int WAIT_TIME = 10;
    private static final int MAX_ATTEMPTS = 10;
    private static final int WAIT_TIME_ATTEMPT = 10;

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (final InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sendKeysToElement(WebDriver driver, By by, String text) {
        boolean exit = false;
        int staleElementReferenceAttempts = 0;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        while (!exit) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
                exit = true;
            } catch (final StaleElementReferenceException es) {
                if (staleElementReferenceAttempts == MAX_ATTEMPTS) {
                    exit = true;
                } else {
                    sleep(WAIT_TIME_ATTEMPT);
                    staleElementReferenceAttempts++;
                }
            }
        }
        if (staleElementReferenceAttempts >= MAX_ATTEMPTS) {
            fail("Error when sendKeysToElement: " + by.toString() + "text: " + text);
        }
    }

    public static void clickOnElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }

    //    We are using "getWindowHandles()" method and it will give us a set of window handles. Fromm this set we
//    can do a foreach which will move through all the window handles
//    Will call each of these windows a "tab" and will say switch to a new window.
//    Since the set of window handles is arranged in the order that they were opened - we know the last handle
//    within the set will be the last opened tab.
    public static void switchBetweenTabs(WebDriver driver) {
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
    }

    // For task #4 I'd use the following method
    public static void clickOnElementAndWaitVisibilityOfAnotherElement(final WebDriver driver, final By elementToClick, By elementToWait) {
        boolean exit = false;
        int noSuchElementAttempts = 0;
        int staleElementReferenceAttempts = 0;
        int elementClickInterceptedExceptionAttempts = 0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        while (!exit) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
                sleep(WAIT_TIME_ATTEMPT);
                wait.until(ExpectedConditions.visibilityOfElementLocated(elementToWait));
                exit = true;
            } catch (final StaleElementReferenceException e1) {
                if (staleElementReferenceAttempts == MAX_ATTEMPTS) {
                    exit = true;
                } else {
                    sleep(WAIT_TIME_ATTEMPT);
                    staleElementReferenceAttempts++;
                }
            } catch (final NoSuchElementException e) {
                if (noSuchElementAttempts == MAX_ATTEMPTS) {
                    exit = true;
                } else {
                    sleep(WAIT_TIME_ATTEMPT);
                    noSuchElementAttempts++;
                }
            } catch (final ElementClickInterceptedException ee) {
                if (elementClickInterceptedExceptionAttempts == MAX_ATTEMPTS) {
                    exit = true;
                } else {
                    sleep(WAIT_TIME_ATTEMPT);
                    noSuchElementAttempts++;
                }
            }

            if (noSuchElementAttempts >= MAX_ATTEMPTS || staleElementReferenceAttempts >= MAX_ATTEMPTS ||
                    elementClickInterceptedExceptionAttempts >= MAX_ATTEMPTS) {
                fail("Error at clickOnElementAndWaitVisibilityOfAnotherElement - elementToClick: " + elementToClick.toString() + "elementToWait: " + elementToWait.toString());
            }
        }
    }

}

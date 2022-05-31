package Utulities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtil {

    public static boolean isClickable(By by){

        boolean result = false;

        try{
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            result = true;

        }catch (TimeoutException e){
            System.out.println("Make sure  locater is correct, or you are on different page");
        }

        return result;

    }

    // wait untill webelement to become visible
    public static boolean isVisible(By by){

        boolean result = false;

        try{
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            result = true;

        }catch (TimeoutException e){
            System.out.println("Make sure  locater is correct, or you are on different page");
        }

        return result;
    }

    // Return the webelement after loaded
    public static WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static void highLightElement(By by, WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(by));

    }
}

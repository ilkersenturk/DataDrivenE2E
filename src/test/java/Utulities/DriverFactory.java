package Utulities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    static String browserName;
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            browserName = ConfigReader.read("browserName");

            switch (browserName.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                /*

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                */
                default:
                    System.out.println("Unkown browser name :" + browserName);
            }

        } else {
            return driver;

        }
        return driver;
    }

    public static void quitBrowser(){

        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}

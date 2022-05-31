package Utulities;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected  Logger log = Logger.getLogger("devpinoyLogger");
    protected static WebDriver driver;
    protected WebDriverWait wait;




    @BeforeSuite
    public void  setup() {

        String log4jConfPath = "src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterSuite
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DriverFactory.quitBrowser();
    }
}

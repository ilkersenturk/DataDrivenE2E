package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Pages.CustomersPage;
import Utulities.BrowserUtil;
import Utulities.DriverFactory;
import Utulities.TestBase;

import java.time.Duration;

public class CustomersTest extends TestBase {

    WebDriver driver = DriverFactory.getDriver();
    CustomersPage customersPage = new CustomersPage();


    @Test
    public void clickOnTable(){

        driver.get(customersPage.url);
        BrowserUtil.highLightElement(customersPage.getTable(), DriverFactory.getDriver());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}


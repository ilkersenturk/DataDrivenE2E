package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.OpenAccountPage;
import Utulities.DriverFactory;
import Utulities.ExcelReader;
import java.io.IOException;


import Utulities.TestBase;

public class OpenAccountTest  extends TestBase {

    WebDriver driver;
    OpenAccountPage openAccountPage = new OpenAccountPage();
    static WebElement dropdown;

    static Select select;

    public OpenAccountTest() {
        this.driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "data-provider-createAnAccount")
    public void createAnAccount(String customerName, String currency){

        driver.get(OpenAccountPage.url);
        //create pageload method in browser util
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dropdown =driver.findElement(openAccountPage.getCustomerNameInput());

        select = new Select(dropdown);
        select.selectByVisibleText(customerName);
        log.debug("Selecting from dropdonw menu customer name : " +customerName);
        dropdown = driver.findElement(openAccountPage.getCurrencyInput());
        select = new Select(dropdown);
        select.selectByVisibleText(currency);
        log.debug("Selecting from dropdown menu currency :" + currency);
        // click on process button
        driver.findElement(openAccountPage.getProcessButton()).click();

        // Dealing with alert
        try {
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        };




    }

    @DataProvider(name = "data-provider-createAnAccount")
    public String[][] getData() throws IOException {

        return ExcelReader.getDataFromExcel("OpenAccountTest");
    }

}

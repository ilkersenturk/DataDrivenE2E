package Test;


import Pages.AddCustomerPage;
import Utulities.BrowserUtil;
import Utulities.ExcelReader;
import Utulities.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;


public class AddCustomerTest extends TestBase {

    AddCustomerPage addCustomerPage = new AddCustomerPage();


    @Test(dataProvider = "data-provider")
    public void addCustomer(String name, String lastname, String zipcode, String alertText) {

        driver.get(addCustomerPage.url);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Alert box  : " + alertText);
        BrowserUtil.highLightElement(addCustomerPage.getFirstNameInput(), driver);
        driver.findElement(addCustomerPage.getFirstNameInput()).sendKeys(name);
        BrowserUtil.highLightElement(addCustomerPage.getLasNameInput(), driver);
        driver.findElement(addCustomerPage.getLasNameInput()).sendKeys(lastname);
        BrowserUtil.highLightElement(addCustomerPage.getPostCodeInput(), driver);
        driver.findElement(addCustomerPage.getPostCodeInput()).sendKeys(zipcode);
        BrowserUtil.highLightElement(addCustomerPage.getAddCustomer(), driver);

        driver.findElement(addCustomerPage.getAddCustomer()).click();
        // Handle alert
        driver.switchTo().alert().accept();
    }


    @DataProvider(name = "data-provider")
    public String[][] getData() throws IOException {

        return ExcelReader.getDataFromExcel("AddCustomerTest");
    }

}

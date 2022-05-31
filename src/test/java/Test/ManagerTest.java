package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ManagerPage;
import Utulities.DriverFactory;
import Utulities.TestBase;

public class ManagerTest extends TestBase {

    WebDriver driver;
    String url ="https://www.way2automation.com/angularjs-protractor/banking/#/manager";
    ManagerPage managerPage = new ManagerPage();
    public ManagerTest() {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void isAddCustomerEnable() {

        driver.get(url);
        WebElement addCustomer = driver.findElement(managerPage.getAddCustomer());
        //Assert.assertTrue(addCustomer.isEnabled());


    }
    @Test
    public void isAddCustomernDisplayed(){

        driver.get(url);
        WebElement addCustomer = driver.findElement(managerPage.getAddCustomer());
        Assert.assertTrue(addCustomer.isDisplayed());
    }

    @Test
    public void isOpenAccountEnable() {

        driver.get(url);
        WebElement openAccount = driver.findElement(managerPage.getOpenAccount());
        Assert.assertTrue(openAccount.isEnabled());

    }
    @Test
    public void isOpenAccountDisplayed(){

        driver.get(url);
        WebElement openAccount = driver.findElement(managerPage.getOpenAccount());
        Assert.assertTrue(openAccount.isDisplayed());
    }
    @Test
    public void isCustomerEnable() {

        driver.get(url);
        WebElement customer = driver.findElement(managerPage.getCustomers());
        Assert.assertTrue(customer.isEnabled());

    }
    @Test
    public void  isCustomerDisplayed(){

        driver.get(url);
        WebElement customer = driver.findElement(managerPage.getCustomers());
        Assert.assertTrue(customer.isDisplayed());
    }

}

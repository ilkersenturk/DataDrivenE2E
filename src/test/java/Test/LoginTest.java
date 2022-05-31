package Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Utulities.BrowserUtil;
import Utulities.ConfigReader;
import Utulities.DriverFactory;
import Utulities.TestBase;

public class LoginTest extends TestBase{

    LoginPage loginpage = new LoginPage();
    String url = ConfigReader.read("url");
    WebDriver driver;

    LoginTest(){

        driver = DriverFactory.getDriver();
    }

    @Test
    public void loginasBankManager() {

        driver.get(url);
        driver.findElement(loginpage.getManagerLoginButton()).click();

        log.debug("loginasBankManager Executed succesfully");
    }



    @Test
    public void isBankManagerLoginEnable() {

        driver.get(url);
        boolean result = driver.findElement(loginpage.getManagerLoginButton()).isEnabled();
        Assert.assertTrue(result);
        log.debug("isBankManagerLoginEnable Executed succesfully");


    }
    @Test
    public void isBankManagerLoginDisplayed(){
        driver.get(url);
        boolean result =driver.findElement(loginpage.getManagerLoginButton()).isDisplayed();
        Assert.assertTrue(result);
        log.debug("isBankManagerLoginDisplayed Executed succesfully");

    }

    @Test
    public void isBankManagerLoginClicable()  {
        driver.get(url);
        boolean result = BrowserUtil.isClickable(loginpage.getManagerLoginButton());
        Assert.assertTrue(result);
        log.debug("isBankManagerLoginClicableExecuted succesfully");
    }
    @Test
    public void ishomeButtonEnable() {

        driver.get(url);
        boolean result = driver.findElement(loginpage.getHomeButton()).isEnabled();
        Assert.assertTrue(result);
        log.debug("ishomeButtonEnable Executed succesfully");


    }
    @Test
    public void ishomeButtonDisplayed(){
        driver.get(url);
        boolean result =driver.findElement(loginpage.getHomeButton()).isDisplayed();
        Assert.assertTrue(result);

    }

    @Test
    public void ishomeButtonClicable()  {
        driver.get(url);
        boolean result = BrowserUtil.isClickable(loginpage.getHomeButton());
        Assert.assertTrue(result);
        log.debug("ishomeButtonClicable Executed succesfully");
    }


    @Test
    public void isMainHeaderExpected(){

        driver.get(url);
        String header = driver.findElement(loginpage.getMainHeader()).getText().toLowerCase().trim();
        String expectedHeader = ConfigReader.read("mainheader").toLowerCase();
        Assert.assertEquals(header,expectedHeader);
        log.debug("isMainHeaderExpected Executed succesfully");
    }

}

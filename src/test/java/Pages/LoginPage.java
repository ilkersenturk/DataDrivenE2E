package Pages;
import org.openqa.selenium.By;
public class LoginPage {

    private final By bankManagerLogin = By.cssSelector("button[ng-click=\"manager()\"]");
    private final By customerLogin = By.cssSelector("button[ng-click=\"customer()\"]");
    private final By homeButton = By.cssSelector("button[ng-click=\"home()\"]");
    private final By mainHeader = By.tagName("strong");

    public LoginPage() {
    }

    public  By getManagerLoginButton(){

        return bankManagerLogin;
    }
    public By getCustomerLoginButton(){
        return customerLogin;
    }
    public By getMainHeader(){
        return mainHeader;
    }
    public By getHomeButton(){
        return homeButton;
    }
}

package Pages;

import org.openqa.selenium.By;

public class OpenAccountPage {

    public static String url = "https://www.way2automation.com/angularjs-protractor/banking/#/manager/openAccount";
    // common element Ask Mehmet Abi
    private final By  addCustomer = ManagerPage.getAddCustomer();
    private final By openAccount = ManagerPage.getOpenAccount();
    private final By customers = ManagerPage.getCustomers();

    private By customerNameInput = By.id("userSelect");
    private By currencyInput = By.id("currency");
    private By processButton = By.cssSelector("button[type='submit']");


    public By getCustomerNameInput() {
        return customerNameInput;
    }

    public By getCurrencyInput() {
        return currencyInput;
    }

    public By getProcessButton() {
        return processButton;
    }
}

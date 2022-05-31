package Pages;
import org.openqa.selenium.By;


public class ManagerPage {

    private static final By addCustomer = By.xpath( "//button[contains(text(),\"Add Customer\")]");
    private static final By openAccount = By.xpath("//button[contains(text(),\"Open Account\")]");
    private static final By customers = By.xpath("//button[contains(text(),\"Customers\")]");


    public static By getAddCustomer(){

        return addCustomer;
    }

    public static By getOpenAccount(){
        return openAccount;
    }
    public static By getCustomers(){
        return customers;
    }
}

package Pages;

import org.openqa.selenium.By;

public class AddCustomerPage {

    public String url = "https://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust";

    private  final  By firstNameInput =  By.cssSelector("input[placeholder='First Name']");
    private  final By lasNameInput  = By.cssSelector("input[placeholder='Last Name']");
    private  final By postCodeInput  = By.cssSelector("input[placeholder='Post Code']");
    private  final By addCustomer = By.cssSelector("button[type='submit']");


    public By getFirstNameInput() {
        return firstNameInput;
    }



    public By getLasNameInput() {
        return lasNameInput;
    }


    public By getPostCodeInput() {
        return postCodeInput;
    }


    public By getAddCustomer() {
        return addCustomer;
    }
}

package Pages;
import org.openqa.selenium.By;
public class CustomersPage {

    public String url ="https://www.way2automation.com/angularjs-protractor/banking/#/manager/list";

    private final By searchInput = By.cssSelector("input[type='text']");
    private final By table = By.className("table-striped");


    public By getSearchInput() {
        return searchInput;
    }

    public By getTable() {
        return table;
    }
}

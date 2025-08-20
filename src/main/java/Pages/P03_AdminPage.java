package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_AdminPage {
    private WebDriver driver;
    private final By userManagementTextNavBar = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[2]");

    public P03_AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNavBarText(){
        String navBarTitle = driver.findElement(userManagementTextNavBar).getText();
        return navBarTitle;
    }
}

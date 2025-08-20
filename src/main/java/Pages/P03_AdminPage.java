package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_AdminPage {
    private WebDriver driver;
    private final By userManagementTextNavBar = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[2]");
    private final By usernameSearchArea = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");

    public P03_AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNavBarText(){
        String navBarTitle = driver.findElement(userManagementTextNavBar).getText();
        return navBarTitle;
    }

    public P03_AdminPage enterUsernameInSearchArea(String targetedUsername){
        Utility.sendData(driver,usernameSearchArea,targetedUsername);
        return this;
    }

    public P03_AdminPage clickSearchButton(){
        Utility.clickOnElement(driver, searchButton);
        return this;
    }
}

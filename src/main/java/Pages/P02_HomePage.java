package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {
    private WebDriver driver;
    private final By adminTab = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    private final By dashboardTextNavBar = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAdminTab(){
        driver.findElement(adminTab);
    }

    public String getNavBarText(){
        String navBarTitle = driver.findElement(dashboardTextNavBar).getText();
        return navBarTitle;
    }
}

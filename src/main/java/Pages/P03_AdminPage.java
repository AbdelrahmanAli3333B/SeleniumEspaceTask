package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P03_AdminPage {
    private WebDriver driver;
    private final By userManagementTextNavBar = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[2]");
    private final By usernameSearchArea = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By resultsTable = By.cssSelector(".oxd-table-body .oxd-table-row");
    private final By firstRowUsername = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div");
    private final By firstRowEmployeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]/div");
    private final By firstRowStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[5]/div");

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

    public int getResultCount(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(resultsTable),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[normalize-space()='No Records Found']"))
                ));

        List<WebElement> rows = driver.findElements(resultsTable);
        int count = 0;
        for (WebElement row : rows) {
            String username = row.findElement(By.xpath(".//div[@role='cell'][2]")).getText().trim();
            if (!username.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public String getUserRoleFromTable(){
        return driver.findElement(firstRowUsername).getText().trim();
    }

    public String getEmployeeNameFromTable(){
        return driver.findElement(firstRowEmployeeName).getText().trim();
    }

    public String getStatusFromTable(){
        return driver.findElement(firstRowStatus).getText().trim();
    }

}

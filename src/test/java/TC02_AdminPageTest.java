import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_AdminPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_AdminPageTest extends TC01_LoginTest {
    P02_HomePage homePage;
    P03_AdminPage adminPage;

    @Test
    public void getAdminPage(){
        validLogin();
        homePage = new P02_HomePage(driver);
        homePage.clickOnAdminTab();
        adminPage = new P03_AdminPage(driver);
        Assert.assertEquals(adminPage.getNavBarText(),"User Management");
    }
}

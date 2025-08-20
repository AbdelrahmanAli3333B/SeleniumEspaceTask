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

public class TC02_AdminPageTest {
    private WebDriver driver;
    P02_HomePage homePage;
    P03_AdminPage adminPage;

    @BeforeMethod

    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void adminPage(){
        adminPage = new P03_AdminPage(driver);
        homePage.clickOnAdminTab();
        Assert.assertEquals(adminPage.getNavBarText(),"User Management");
    }
}

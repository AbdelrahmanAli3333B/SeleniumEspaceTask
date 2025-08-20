import Pages.P02_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import Pages.P01_LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.P03_AdminPage;

import java.time.Duration;

public class TC01_LoginTest {
    protected WebDriver driver;
    P01_LoginPage loginPage;
    P02_HomePage homePage;


    @BeforeMethod
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void validLogin(){
        homePage = new P02_HomePage(driver);
        new P01_LoginPage(driver)
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLoginButton();
        Assert.assertEquals(homePage.getNavBarText(),"Dashboard");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}

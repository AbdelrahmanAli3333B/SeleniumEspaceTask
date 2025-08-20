package Tests;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected P01_LoginPage loginPage;
    protected P02_HomePage homePage;

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new P01_LoginPage(driver);
        homePage = new P02_HomePage(driver);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
        Assert.assertEquals(homePage.getNavBarText(),"Dashboard");
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}

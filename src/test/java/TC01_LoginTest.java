import Pages.P02_HomePage;
import com.fasterxml.jackson.databind.ser.Serializers;
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

public class TC01_LoginTest extends Tests.BaseTest {
    P01_LoginPage loginPage;
    P02_HomePage homePage;

    @Test
    public void validLogin(){
        login("Admin","admin123");
    }

}

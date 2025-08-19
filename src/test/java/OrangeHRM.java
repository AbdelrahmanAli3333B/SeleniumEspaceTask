import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class OrangeHRM {

    public static WebDriver driver = new ChromeDriver();

    public static void openURL(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void Login (String username, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        By usernameInput = By.name("username");
        By passwordInput = By.name("password");
        By submitButton = By.cssSelector("button[type='submit']");
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed(), "Dashboard");
    }

    public static void SearchForUser (String targetedUsername){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        By adminScreen = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
        By userSearch = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
        driver.findElement(adminScreen).click();
        driver.findElement(userSearch).sendKeys(targetedUsername + Keys.ENTER);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        Assert.assertEquals(rows.size(), 1);
        System.out.println("Number of result rows: " + rows.size());
        //aaaa
    }


        //1. Navigate to https://opensource-demo.orangehrmlive.com
        @BeforeClass
        public void setUp(){
            openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

        //2. Login using Username: Admin & Password: admin123
        @Test(priority = 1)
        public void loginTest(){
            Login("Admin", "admin123");
        }

        //3. Click the Admin tab on the left sidebar
        //4. Search using the username for the admin user
        //5. Assert that the number of results, the username, the user role, and the status are correct
        @Test(priority = 2, dependsOnMethods = {"loginTest"})
        public void searchForUser(){
            String targetedUsername = "user9599";
            SearchForUser(targetedUsername);
        }

        //6. Click the Delete icon (trash bin) on the table

        //7. Assert that the admin user deletion is not allowed (either nothing happens, or an error appears)

    }






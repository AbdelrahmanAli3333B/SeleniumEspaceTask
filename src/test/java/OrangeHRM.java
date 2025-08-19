import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
    }

    public static void main(String[] args) {
        //1. Navigate to https://opensource-demo.orangehrmlive.com
        openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //2. Login using Username: Admin & Password: admin123
        Login("Admin", "admin123");

        //3. Click the Admin tab on the left sidebar

        //4. Search using the username for the admin user

        //5. Assert that the number of results, the username, the user role, and the status are correct

        //6. Click the Delete icon (trash bin) on the table

        //7. Assert that the admin user deletion is not allowed (either nothing happens, or an error appears)

    }
}





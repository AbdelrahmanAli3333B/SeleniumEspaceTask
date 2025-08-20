package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class P01_LoginPage {
    private WebDriver driver;
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernameText){
        driver.findElement(usernameInput).sendKeys(usernameText);
    }

    public void enterPassword(String passwordText){
        driver.findElement(passwordInput).sendKeys(passwordText);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}

package Pages;

import Utilities.Utility;
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

    public P01_LoginPage enterUsername(String usernameText){
        Utility.sendData(driver,usernameInput,usernameText);
        return this;

    }

    public P01_LoginPage enterPassword(String passwordText){
        Utility.sendData(driver,passwordInput,passwordText);
        return this;
    }

    public P02_HomePage clickLoginButton(){
        Utility.clickOnElement(driver, loginButton);
        return  new P02_HomePage(driver);
    }
}

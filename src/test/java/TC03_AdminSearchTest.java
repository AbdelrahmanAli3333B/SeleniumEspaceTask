import Pages.P02_HomePage;
import Pages.P03_AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_AdminSearchTest extends Tests.BaseTest {
    P02_HomePage homePage;
    P03_AdminPage adminPage;

    @Test
    public void searchForUserName(){
        login("Admin","admin123");
        homePage = new P02_HomePage(driver);
        homePage.clickOnAdminTab();
        adminPage = new P03_AdminPage(driver);
        adminPage.enterUsernameInSearchArea("Admin").clickSearchButton();
        Assert.assertEquals(adminPage.getResultCount(),1);
    }
}

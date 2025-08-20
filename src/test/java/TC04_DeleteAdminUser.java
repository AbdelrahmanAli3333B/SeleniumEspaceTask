import Pages.P02_HomePage;
import Pages.P03_AdminPage;
import Utilities.DataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TC04_DeleteAdminUser extends Tests.BaseTest{

    P02_HomePage homePage;
    P03_AdminPage adminPage;

    @Test
    public void deleteAdminUser() throws FileNotFoundException, InterruptedException {
        login(DataUtil.getJsonData("myTestData","username")
                ,DataUtil.getJsonData("myTestData","password"));
        homePage = new P02_HomePage(driver);
        homePage.clickOnAdminTab();
        adminPage = new P03_AdminPage(driver);
        adminPage.enterUsernameInSearchArea(DataUtil.getJsonData("myTestData","targetedUsername"))
                .clickSearchButton()
                .clickDeleteUserButton();

    }
}

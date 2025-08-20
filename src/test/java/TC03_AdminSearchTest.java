import Pages.P02_HomePage;
import Pages.P03_AdminPage;
import Utilities.DataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TC03_AdminSearchTest extends Tests.BaseTest {
    P02_HomePage homePage;
    P03_AdminPage adminPage;

    @Test
    public void searchForUserName() throws FileNotFoundException {
        login(DataUtil.getJsonData("myTestData","username")
                ,DataUtil.getJsonData("myTestData","password"));
        homePage = new P02_HomePage(driver);
        homePage.clickOnAdminTab();
        adminPage = new P03_AdminPage(driver);
        adminPage.enterUsernameInSearchArea(DataUtil.getJsonData("myTestData","targetedUsername")).clickSearchButton();
        Assert.assertEquals(adminPage.getResultCount(),1);
        Assert.assertEquals(adminPage.getUserRoleFromTable(),"Admin");
        Assert.assertEquals(adminPage.getEmployeeNameFromTable(),"manda user");
        Assert.assertEquals(adminPage.getStatusFromTable(),"Enabled");
    }
}

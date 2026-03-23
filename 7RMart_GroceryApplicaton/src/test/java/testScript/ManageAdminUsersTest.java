package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageAdminUsersPage;
import utilities.ExcelUtility;

public class ManageAdminUsersTest extends Base {
	public HomePage homepage;
	public ManageAdminUsersPage manageadminuserspage;

	@Test(priority = 1, description = "Login and Manage AdminUsers", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidCredentialsAndManageAdminUsers() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String adminusername = ExcelUtility.getStringData(1, 3, "loginpage");
		String adminpassword = ExcelUtility.getStringData(1, 4, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		manageadminuserspage = homepage.clickAdminUsersMoreInfoButton();
		manageadminuserspage.clickAdminUsersNewButton().inputAdminUsername(adminusername)
				.inputAdminPassword(adminpassword).selectAdminUsersType().saveAdminDetails().alertDisplayofAdmin();
		boolean alert = manageadminuserspage.alertDisplayofAdmin();
		Assert.assertTrue(alert, Constant.ADMINDETAILSSAVINGFAILED);
	}

}

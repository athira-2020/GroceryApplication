package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test(priority = 1, description = "Login and Logout", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidCredentialsAndLogout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		loginpage.clickSignInButton();

		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogout();
		boolean loginboxmessage = logoutpage.loginBoxMessageDisplay();
		Assert.assertTrue(loginboxmessage, Constant.LOGOUTFAILED);
	}

}

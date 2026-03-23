package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	public HomePage homepage;

	@Test(priority = 1, description = "Login successfull with valid credentials", retryAnalyzer = retry.Retry.class, groups = {
			"regression" })
	public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		boolean homepage = loginpage.displayDashboard();
		Assert.assertTrue(homepage, Constant.UNABLETOLOGINWITHVALIDUSERNAMEVALIDPASSWORD);
	}

	@Test(priority = 2, description = "Login failed with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidUsernameInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		boolean alertmessage = loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(alertmessage, Constant.LOGINWITHINVALIDPASSWORD);
	}

	@Test(priority = 3, description = "Login failed with invalid username and valid password", retryAnalyzer = retry.Retry.class, groups = {
			"regression" })
	public void verifyTheUserIsAbleToLoginWithInvalidUsernameValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		boolean alertmessage = loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(alertmessage, Constant.LOGINWITHINVALIDUSERNAME);
	}

	@Test(priority = 4, description = "Login failed with invalid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithInvalidUsernameInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		boolean alertmessage = loginpage.isErrorMessageDisplayed();
		Assert.assertTrue(alertmessage, Constant.LOGINWITHINVALIDUSERNAMEINVALIDPASSWORD);
	}

}

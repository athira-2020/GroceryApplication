package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	public HomePage homepage;
	public ManageFooterPage managefooterpage;

	@Test(priority = 1, description = "Login and Manage Footer", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidCredentialsAndManageFooter() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String address = ExcelUtility.getStringData(1, 6, "loginpage");
		String email = ExcelUtility.getStringData(1, 7, "loginpage");
		String phonenumber = ExcelUtility.getStringData(1, 8, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		managefooterpage = homepage.clickFooterMoreInfoButton();
		managefooterpage.clickButtonPrimary().inputAddress(address).inputEmailAddress(email)
				.inputPhoneNumber(phonenumber).clickButtonUpdate();
		boolean alert = managefooterpage.displayAlert();
		Assert.assertTrue(alert, Constant.FOOTERTEXTUPDATIONFAILED);

	}

}

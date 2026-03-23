package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	public HomePage homepage;
	public ManageNewsPage managenewspage;

	@Test(priority = 1, description = "Login and Manage News", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidCredentialsAndManageNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String newsInput = ExcelUtility.getStringData(1, 2, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		managenewspage = homepage.clickManageNewsMoreInfoButton();
		managenewspage.clickNewButton().inputTextToField(newsInput).clickSaveButton().alertDisplay();
		boolean alert = managenewspage.alertDisplay();
		Assert.assertTrue(alert, Constant.NEWSSAVINGFAILED);
	}

}

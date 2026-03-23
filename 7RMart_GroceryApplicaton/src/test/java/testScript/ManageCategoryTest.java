package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	public HomePage homepage;
	public ManageCategoryPage managecategorypage;

	@Test(priority = 1, description = "Login and Manage Category", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidCredentialsAndManageCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String category = ExcelUtility.getStringData(1, 5, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		managecategorypage = homepage.clickManageCategoryMoreInfoButton();
		managecategorypage.clickCategoryNewButton().clickCategoryButton(category).clickDiscountButton()
				.clickChooseFileButton().clickCategorySaveButton().alertDisplayofCategory();
		boolean alert = managecategorypage.alertDisplayofCategory();
		Assert.assertTrue(alert, Constant.CATEGORYADDITIONFAILED);
	}

}

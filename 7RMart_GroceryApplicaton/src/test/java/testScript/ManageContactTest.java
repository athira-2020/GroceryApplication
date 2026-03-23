package testScript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	public HomePage homepage;
	public ManageContactPage managecontactpage;

	@Test(priority = 1, description = "Login and Manage Contacts", retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginWithValidCredentialsAndManageContact() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		String address = ExcelUtility.getStringData(1, 6, "loginpage");
		String email = ExcelUtility.getStringData(1, 7, "loginpage");
		String phonenumber = ExcelUtility.getStringData(1, 8, "loginpage");
		String deliverytime = ExcelUtility.getStringData(1, 9, "loginpage");
		String deliverycharge = ExcelUtility.getStringData(1, 10, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username).enterThePassword(password);
		homepage = loginpage.clickSignInButton();

		managecontactpage = homepage.clickContactPageMoreInfoButton();
		managecontactpage.clickButtonPrimary().inputPhoneNumber(phonenumber).inputEmailAddress(email)
				.inputAddress(address).inputDeliveryTime(deliverytime).inputDeliveryCharge(deliverycharge)
				.clickButtonUpdate();
		boolean alert = managecontactpage.displayAlert();
		Assert.assertTrue(alert, Constant.CONTACTUSADDITIONFAILED);
	}
}

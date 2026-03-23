package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageAdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement adminUsersNewButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminUsersUsername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminUsersPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement adminUsersUserType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement adminSaveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement adminAlertDisplay;

	public ManageAdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageAdminUsersPage clickAdminUsersNewButton() {
		adminUsersNewButton.click();
		return this;
	}

	public ManageAdminUsersPage inputAdminUsername(String adminusername) {
		adminUsersUsername.sendKeys(adminusername);
		return this;
	}

	public ManageAdminUsersPage inputAdminPassword(String adminpassword) {
		adminUsersPassword.sendKeys(adminpassword);
		return this;
	}

	public ManageAdminUsersPage selectAdminUsersType() {
		pageutility.dropDownIndex(adminUsersUserType, 1);
		return this;
	}

	public ManageAdminUsersPage saveAdminDetails() {
		adminSaveButton.click();
		return this;
	}

	public boolean alertDisplayofAdmin() {
		return adminAlertDisplay.isDisplayed();
	}

}

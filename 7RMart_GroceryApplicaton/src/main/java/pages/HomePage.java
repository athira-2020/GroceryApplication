package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@class='small-box-footer' and contains(@href,'list-admin')]")
	WebElement adminUsersMoreInfoButton;
	@FindBy(xpath = "//a[contains(text(),'More info') and contains(@href,'list-category')]")
	WebElement manageCategoryMoreInfoButton;
	@FindBy(xpath = "//a[contains(@href,'list-contact') and contains(@class,'nav-link')]")
	WebElement manageContactMoreInfobutton;
	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href,'list-footertext')]")
	WebElement manageFooterMoreInfoButton;
	@FindBy(xpath = "//a[@class='small-box-footer' and contains(@href, 'list-news')]")
	WebElement manageNewsMoreInfoButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageAdminUsersPage clickAdminUsersMoreInfoButton() {
		adminUsersMoreInfoButton.click();
		return new ManageAdminUsersPage(driver);
	}

	public ManageCategoryPage clickManageCategoryMoreInfoButton() {
		manageCategoryMoreInfoButton.click();
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage clickContactPageMoreInfoButton() {
		manageContactMoreInfobutton.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterPage clickFooterMoreInfoButton() {
		manageFooterMoreInfoButton.click();
		return new ManageFooterPage(driver);
	}

	public ManageNewsPage clickManageNewsMoreInfoButton() {
		manageNewsMoreInfoButton.click();
		return new ManageNewsPage(driver);
	}
}

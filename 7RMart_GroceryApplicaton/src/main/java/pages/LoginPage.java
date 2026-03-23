package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardDisplay;
	@FindBy(xpath = "//div[contains(@class, 'alert-danger')]")
	WebElement errormessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterTheUsername(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterThePassword(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickSignInButton() {
		signInButton.click();
		return new HomePage(driver);
	}

	public boolean displayDashboard() {
		return dashboardDisplay.isDisplayed();
	}

	public boolean isErrorMessageDisplayed() {
		return errormessage.isDisplayed();
	}

}

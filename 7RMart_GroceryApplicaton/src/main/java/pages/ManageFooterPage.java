package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath = "//a[contains(@href,'edit=1')]")
	WebElement buttonPrimary;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement textareaAddress;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddress;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumber;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement buttonUpdate;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement alertDisplay;

	public ManageFooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageFooterPage clickButtonPrimary() {
		buttonPrimary.click();
		return this;
	}

	public ManageFooterPage inputAddress(String address) {
		textareaAddress.clear();
		textareaAddress.sendKeys(address);
		return this;
	}

	public ManageFooterPage inputEmailAddress(String emailaddress) {
		emailAddress.clear();
		emailAddress.sendKeys(emailaddress);
		return this;
	}

	public ManageFooterPage inputPhoneNumber(String phonenumber) {
		phoneNumber.clear();
		phoneNumber.sendKeys(phonenumber);
		return this;
	}

	public ManageFooterPage clickButtonUpdate() {
		pageutility.click(driver, buttonUpdate);
		return this;
	}

	public boolean displayAlert() {
		return alertDisplay.isDisplayed();
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement buttonPrimary;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumber;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddress;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement textareaAddress;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliveryCharge;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement buttonUpdate;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement alertDisplay;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageContactPage clickButtonPrimary() {
		buttonPrimary.click();
		return this;
	}

	public ManageContactPage inputPhoneNumber(String phonenumber) {
		phoneNumber.clear();
		phoneNumber.sendKeys(phonenumber);
		return this;
	}

	public ManageContactPage inputEmailAddress(String emailaddress) {
		emailAddress.clear();
		emailAddress.sendKeys(emailaddress);
		return this;
	}

	public ManageContactPage inputAddress(String address) {
		textareaAddress.clear();
		textareaAddress.sendKeys(address);
		return this;
	}

	public ManageContactPage inputDeliveryTime(String deliverytime) {
		deliveryTime.clear();
		deliveryTime.sendKeys(deliverytime);
		return this;
	}

	public ManageContactPage inputDeliveryCharge(String deliverycharge) {
		deliveryCharge.clear();
		deliveryCharge.sendKeys(deliverycharge);
		return this;
	}

	public ManageContactPage clickButtonUpdate() {
		pageutility.click(driver, buttonUpdate);
		return this;
	}

	public boolean displayAlert() {
		return alertDisplay.isDisplayed();
	}

}

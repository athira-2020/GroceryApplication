package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@class='dropdown-item' and contains(@href,'logout')]")
	WebElement logout;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement loginboxmessagedisplay;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		logout.click();
	}

	public void clickAdmin() {
		admin.click();
	}

	public boolean loginBoxMessageDisplay() {
		return loginboxmessagedisplay.isDisplayed();
	}

}

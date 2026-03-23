package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,'news/add')]")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement inputTextField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement alertDisplay;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage clickNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage inputTextToField(String input) {
		inputTextField.sendKeys(input);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean alertDisplay() {
		return alertDisplay.isDisplayed();

	}

}

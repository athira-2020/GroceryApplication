package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath = "//a[contains(@href,'Category/add')]")
	WebElement categoryNewButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryButton;
	@FindBy(xpath = "//li[contains(@class,'ms-elem-selectable') and contains(@id,'134-selectable')]")
	WebElement discountButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']")
	WebElement categorySaveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement categoryCreationAlert;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageCategoryPage clickCategoryNewButton() {
		categoryNewButton.click();
		return this;
	}

	public ManageCategoryPage clickCategoryButton(String category) {
		categoryButton.sendKeys(category);
		return this;
	}

	public ManageCategoryPage clickDiscountButton() {
		discountButton.click();
		return this;
	}

	public ManageCategoryPage clickChooseFileButton() {
		fileuploadutility.fileUploadUsingSendkeys(chooseFileButton, Constant.IMAGEOFMANGO);
		return this;
	}

	public ManageCategoryPage clickCategorySaveButton() {
		pageutility.click(driver, categorySaveButton);
		return this;
	}

	public boolean alertDisplayofCategory() {
		return categoryCreationAlert.isDisplayed();
	}

}

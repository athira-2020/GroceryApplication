package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	// Dropdown methods
	public void dropDownVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void dropDownIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void dropDownValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// alert methods
	public void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void confirmationAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void promptAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	// action class
	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).perform();
	}

	public void rightClick(WebDriver driver, WebElement input) {
		Actions actions = new Actions(driver);
		actions.contextClick(input).perform();
	}

	public void mouseOver(WebDriver driver, WebElement input) {
		Actions actions = new Actions(driver);
		actions.moveToElement(input).perform();
	}

	public void click(WebDriver driver, WebElement input) {
		Actions actions = new Actions(driver);
		actions.click(input).perform();
	}

	public void doubleClick(WebDriver driver, WebElement input) {
		Actions actions = new Actions(driver);
		actions.doubleClick(input).perform();
	}

}

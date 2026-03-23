package utilities;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendkeys(WebElement elementname, String path) {
		elementname.sendKeys(path);
	}

}

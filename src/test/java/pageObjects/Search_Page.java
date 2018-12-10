package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search_Page {
	
	private WebElement element = null;

	public WebElement txtbx_Search(WebDriver driver) {

		element = driver.findElement(By.id("search-box"));

		return element;

	}
	public WebElement btn_Search(WebDriver driver) {

		element = driver.findElement(By.className("sb-button"));

		return element;

	}

}

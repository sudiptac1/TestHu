package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult_Page {
	
	public List<WebElement>  ele_Result(WebDriver driver) {

		List<WebElement> elementC = null;
		
		elementC = driver.findElements(By.xpath("//a"));
		return elementC;

	}

}

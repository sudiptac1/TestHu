package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SearchResult_Page;
import pageObjects.Search_Page;

public class serachHuddlefeature {
	
	private final static Logger logger = Logger.getLogger(serachHuddlefeature.class);
	WebDriver driver = null;

	@Before
	public void StartBrowser() {
		System.setProperty("webdriver.chrome.driver", "Lib//chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		logger.info("browser starting");
	}

	@After
	public void quitBrowser() {
		//driver.quit();
	}
	@Given("^I am a user of Huddle$")
	public void i_am_a_user_of_Huddle() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I launch into https://uk\\.ask\\.com$")
	public void i_launch_into_https_uk_ask_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.get("https://uk.ask.com");
		logger.info("at ask.com page");
		
	}

	@When("^Search for the key words \"([^\"]*)\"$")
	public void search_for_the_key_words(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("inside when search");
		Search_Page searchP = new Search_Page();
		
		searchP.txtbx_Search(driver).sendKeys(arg1);
		searchP.btn_Search(driver).click();
		
		
	}

	@Then("^I should be able to see the see the key words \"([^\"]*)\" in the search results$")
	public void i_should_be_able_to_see_the_see_the_key_words_in_the_search_results(String arg1) throws Throwable {
	   
		System.out.println("inside then");
		SearchResult_Page searchRe = new SearchResult_Page();
		
		System.out.println("inside thenagain"+searchRe.ele_Result(driver).size());
		List<String> results = new ArrayList<>();
		for (WebElement ele: searchRe.ele_Result(driver)) {
			results.add(ele.getText().toLowerCase());
			System.out.println(ele.getText());
		
		}

		  
		  assertTrue(!results.contains(arg1.toLowerCase()));
		  
	}

}

package stepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
	
	WebDriver driver;
	@Given("I want launch the {string} browser")
	public void i_want_launch_the_browser(String browser) {
	   
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("I enter the url {string}")
	public void i_enter_the_url(String url) {
	    driver.get(url);
		
	}
	
	@When("homw page is  displayed I want search for {string}")
	public void homw_page_is_displayed_i_want_search_for(String course) {
	   WebElement searchIcon = driver.findElement(By.xpath("//i[@class='icon-search']"));
		Actions act=new Actions(driver);
		act.moveToElement(searchIcon).build().perform();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(course, Keys.ENTER);
	}
	
	@When("get count each course and title of course")
	public void get_count_each_course_and_title_of_course() {
	   
		List<WebElement> courseList = driver.findElements(By.xpath("//h2[@class='post-title entry-title']/a[text()]"));
		System.out.println("Display course count : "+courseList.size());
		for(WebElement course:courseList) {
			System.out.println(course.getText());
		}
	}
	
	@Then("verify in the search result {string} name is there or not")
	public void verify_in_the_search_result_name_is_there_or_not(String expectedHeader) {
	   
		String actualHeader = driver.findElement(By.xpath("//h1[@class='page-title']/em")).getText();
		Assert.assertEquals(actualHeader, expectedHeader.toUpperCase());
		
	}
	
	@Then("close all the browser")
	public void close_the_browser() {
	   driver.close();
	}

	
	@Given("go to my account tab")
	public void go_to_my_account_tab() {
	    
		driver.findElement(By.linkText("My Account")).click();
	}
	@When("login page is displayed enter the username {string} and password {string}")
	public void login_page_is_displayed_enter_the_username_and_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
	}
	
	@When("click On login")
	public void click_on_login() {
		driver.findElement(By.xpath("((//input[@value=\"Login\"])[1])")).click();
	}
	
	@When("click on account details")
	public void click_on_account_details() {
	    
		driver.findElement(By.linkText("Account Details")).click();
	}
	@When("In account details page fill first name, last name, current password, new password and confirm password")
	public void in_account_details_page_fill_first_name_last_name_current_password_new_password_and_confirm_password(DataTable dataTable) {
		List<List<String>> data=dataTable.asLists(String.class);
	    //first get method as row,2nd get method as column
	    String first_name=data.get(1).get(0);
	    String last_name=data.get(1).get(1);
	    String current_password=data.get(1).get(2);
	    String new_password=data.get(1).get(3);
	    String confirm_password=data.get(1).get(4);
	    
	    /* List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    String first_name=data.get(0).get("first name");
	    String last_name=data.get(0).get("Lastname");
	    String current_password=data.get(0).get("Current password");
	    String new_password=data.get(0).get("Newn password");
	    String confirm_password=data.get(0).get("confirm password");*/
	    
	    WebElement firstTF = driver.findElement(By.id("account_first_name"));
	    firstTF.clear();
	    firstTF.sendKeys(first_name);
	    
	    WebElement lastTF = driver.findElement(By.id("account_last_name"));
	    lastTF.clear();
	    lastTF.sendKeys(last_name);
	    
	    driver.findElement(By.id("password_current")).sendKeys(current_password);
	    driver.findElement(By.id("password_1")).sendKeys(new_password);
	    driver.findElement(By.id("password_2")).sendKeys(confirm_password);
	    
	    
	}
	
	
	@When("click on save changes")
	public void click_on_save_changes() {
	   driver.findElement(By.name("save_account_details")).click();
		
	}
	@Then("verify the successfull message displayed or not {string}")
	public void verify_the_successfull_message_displayed_or_not(String expectedMsg) {
	    
		String actualMsg = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}


}

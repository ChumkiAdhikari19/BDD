package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ecommerce.baseutilis.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	
	Base base;
	public LoginTest(Base base) {
		this.base=base;
	}
	
	//cntrl + shift+o
	//WebDriver driver;
	
	String username1="adhikarybristi1910";
	@Given("As a user I will launch browser")
	public void as_a_user_i_will_launch_browser() {
	    WebDriverManager.chromedriver().setup(); // not using exe file so using this
	    //System.setProperty("webdriver.chrome.driver","C:\Users\HP\Downloads\chromedriver_win32\chromedriver.exe");
		base.driver=new ChromeDriver();
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@Given("Enter the url")
	public void enter_the_url() {
		base.driver.get("http://practice.automationtesting.in/");
	}

	@Given("click on myAccount")
	public void click_on_my_account() {
		base.driver.findElement(By.linkText("My Account")).click();
	}
	
	
	@When("login page is displayed I will enter username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
	    
		base.driver.findElement(By.id("username")).sendKeys("adhikarybristi1910@gmail.com");
		base.driver.findElement(By.id("password")).sendKeys("Chumadhikari@19 ");
		
	}
	

	@When("click on login")
	public void click_on_login() {
		base.driver.findElement(By.xpath("((//input[@value=\"Login\"])[1])")).click();
	    
		
	}
	

	@Then("I will verify the user name is present or not")
	public void i_will_verify_the_user_name_is_present_or_not() {
		String actualusername = base.driver.findElement(By.xpath("//strong[text()]")).getText();
		Assert.assertTrue(username1.contains(actualusername));
	}
	

	@Then("Signout from the application")
	public void signout_from_the_application() {
		
		base.driver.findElement(By.linkText("Sign out")).click();
		base.driver.close();
	    
	}
	
	@When("login page is displayed I will enter valid username {string} and invalid password {string}")
	public void login_page_is_displayed_i_will_enter_valid_username_and_invalid_password(String username, String password) {
		base.driver.findElement(By.id("username")).sendKeys(username);
		base.driver.findElement(By.id("password")).sendKeys(password);
		
		
	}
	
	@Then("verify that error message is displayed or not")
	public void verify_that_error_message_is_displayed_or_not() {
	    
		String errorMsg = base.driver.findElement(By.xpath("//ul[@class=\"woocommerce-error\"]/li[text()]")).getText();
		Assert.assertTrue(errorMsg.contains("ERROR"));
	}
	
	@Then("close the browser")
	public void close_the_browser() {
		base.driver.close();
	}
	



}

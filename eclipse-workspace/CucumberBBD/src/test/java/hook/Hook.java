package hook;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecommerce.baseutilis.Base;
import com.ecommerce.baseutilis.FileUtility;
import com.ecommerce.baseutilis.WebDriverUtility;
import com.ecommerce.pom.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;


public class Hook {
	
	Base base;
	public Hook (Base base) {     ///to create constructor initialize base cls data
		this.base=base;
	}
	
	@Before
	public void setUp() throws Throwable{
		base.fUtil=new FileUtility();
		base.webUtility=new WebDriverUtility();
		String browser = base.fUtil.getKeyValue("browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//base.pageObjManager=new PageObjectManager(base.driver);
	}
	
	
	@After                        //we can use @AfterStep
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = base.webUtility.takeScreenshot(base.driver);
			saveScreenshot(screenshot);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
		}
		base.driver.quit();
	}
		@Attachment(value = "Page screenshot", type = "image/png")
		public byte[] saveScreenshot(byte[] screenShot) {
		    return screenShot;
	}
}



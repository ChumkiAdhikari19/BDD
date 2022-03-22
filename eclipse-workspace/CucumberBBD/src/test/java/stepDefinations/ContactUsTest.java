package stepDefinations;

import com.ecommerce.baseutilis.Base;
import com.ecommerce.baseutilis.ExcelUtility;
import com.ecommerce.pom.AddToBasketPage;
import com.ecommerce.pom.ContactUsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsTest {
	
	Base base;
	public ContactUsTest(Base base) {
		this.base=base;
		
	}

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		base.contactusPage=base.pageObjManager.initcontactuspage();
		base.driver.get("http://automationpractice.com/index.php?controller=contact");
	}

	
	@When("user fill the form from given sheetname {string} and rownumber {int}")
	public void user_fill_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {
		base.contactusPage=new ContactUsPage(base.driver);
		
		
	}
	

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
	   
		
	}
	

	@Then("it shows successfull message {string}")
	public void it_shows_successfull_message(String string) {
	    
		
	}

}

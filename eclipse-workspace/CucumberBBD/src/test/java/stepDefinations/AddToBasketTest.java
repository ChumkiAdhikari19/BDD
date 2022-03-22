package stepDefinations;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ecommerce.baseutilis.Base;
import com.ecommerce.pom.AddToBasketPage;
import com.ecommerce.pom.HomePage;
import com.ecommerce.pom.ShopPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToBasketTest {
	
	
	Base base;
	public AddToBasketTest(Base base) {
		this.base=base;
		
	}
	
	String actualProdname="[[[Functional Programming in JS]]";
	
	@Given("enter the Url {string}")
	public void enter_the_url(String url) {
		base.addToBasket=base.pageObjManager.initaddToBasketpage();
		base.driver.get(url);
	}
	
	@When("home page is displayed click on shop")
	public void home_page_is_displayed_click_on_shop() {
		base.addToBasket=new AddToBasketPage(base.driver);
		base.addToBasket.getShopLink().click();
		
	}
	
	@Then("add any product by clicking on AddToBasket button")
	public void add_any_product_by_clicking_on_add_to_basket_button() {
		base.addToBasket=new AddToBasketPage(base.driver);
		base.addToBasket.getAddToB().click();
		
	}
	
	@Then("click on ViewBasket")
	public void click_on_view_basket() {
		base.addToBasket=new AddToBasketPage(base.driver);
		base.addToBasket.getViewBasket();
	}
	
	@Then("verify same product added")
	public void verify_same_product_added() {
		base.addToBasket=new AddToBasketPage(base.driver);
	    
		WebElement productName = base.addToBasket.getProductName();
		String expectedprodName = productName.getText();
		System.out.println(expectedprodName);
		Assert.assertEquals(actualProdname, expectedprodName);
			
		
		
	}
}

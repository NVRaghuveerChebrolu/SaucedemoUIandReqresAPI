package qumu;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import pom.HomePagePOM;
import pom.ProductDetailsPOM;

public class ProductDetailsPage extends BasePage {
	
	static ProductDetailsPOM productPage = new ProductDetailsPOM(driver);

	 
	public static void AddingItemsToCart(DataTable dataTable) {
	
  
		//List<String> items = dataTable.asList();
//        for (String item : items) {
//            String xpath = "//div[contains(text(),'" + item + "')]/ancestor::div[@class='inventory_item']//button";
//            WebElement addToCartButton = driver.findElement(By.xpath(xpath));
//            addToCartButton.click();
//        }
		 
		  
		  productPage.sauceLabsBoltTshirt();
		  productPage.sauceLabsBackPackAddToCart();
		  productPage.sauceLabsFleeceJacketAddToCart();
		  productPage.saucelabsOnesie();
		  
		  
		  
		
	}
	
	public static void ItemsCountInCart(Integer itemscount)
	{
		productPage.ShoppingCartBadge(itemscount);
	}
	
	public static void ClickOnShoppingcart() {
		productPage.ClickOncart();

	}
	
	public static void CheckQTYCount(Integer QTYcount)
	{
		
		productPage.ValidateQTYCountInCart(QTYcount);
	}
	
	public static void RemoveJacket(DataTable datable)
	{
		productPage.RemoveJacketFromCart(datable);
	}
	
	public static void ValidateCartAfterRemovingJacket(int ItemsCountAfterRemovingJacket)
	{
		productPage.ItemsCountAfterRemovingJacket(ItemsCountAfterRemovingJacket);
	}
	
	
	public static void ClickOnCheckBoxButton()
	{
		productPage.ClickOnCheckBox();
	}
	
	public static void EnterFirstName(String Fname)
	{
		productPage.EnterFirstNameInTextField(Fname);
	}
	
	public static void EnterLnametName(String Lname)
	{
		productPage.EnterlastNameInTextField(Lname);
	}
	
	public static void EnterZipcode(String zipcode)
	{
		productPage.EnterPostalCode(zipcode);
	}
	
	public static void ContinueButton()
	{
		productPage.ClickOnContinueButton();
	}
	
	public static void TotalItemsCountInCheckout()
	{
		productPage.TotalItemsInCheckoutPage();
	}
	
	public static void TotalTaxRate()
	{
		productPage.TaxRateAppliedToTotal();
	}
}


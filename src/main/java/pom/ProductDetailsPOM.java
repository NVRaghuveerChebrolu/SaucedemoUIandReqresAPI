package pom;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

public class ProductDetailsPOM {
	public WebDriver driver;
	int QTYShirtCount,QTYJacketCount,QTYOneSieCount,QTYBackPackCount;

	public ProductDetailsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	public WebElement sauceBackPack;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	public WebElement sauceLabsJacket;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	public WebElement saucelabsTshirt;

	@FindBy(id = "add-to-cart-sauce-labs-onesie")
	public WebElement sauceOnesie;

	// items count xpath
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement ShoppingBadge;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement cartLink;

	@FindBy(xpath = " //div[contains(text(), 'Bolt T-Shirt')]/../../../div[@class='cart_quantity']")
	public WebElement QTYShirt;

	@FindBy(xpath = " //div[contains(text(), 'Fleece Jacket')]/../../../div[@class='cart_quantity']")
	public WebElement QTYJacket;

	@FindBy(xpath = "  //div[contains(text(), 'Onesie')]/../../../div[@class='cart_quantity']")
	public WebElement QTYOneSie;

	@FindBy(xpath = " //div[contains(text(), 'Backpack')]/../../../div[@class='cart_quantity']")
	public WebElement QTYBackPack;

	//@FindBy(id = "remove-sauce-labs-fleece-jacket")
	
	public WebElement RemoveItemsFromCart(String itemTobeRemoved) {
		return driver.findElement(By.xpath("//div[text()='"+itemTobeRemoved+"']/../following-sibling::div[@class='item_pricebar']/button"));
	}

	@FindBy(id = "checkout")
	public WebElement CheckOutButton;

	@FindBy(id = "first-name")
	public WebElement FirstName;

	@FindBy(id = "last-name")
	public WebElement LastName;

	@FindBy(id = "postal-code")
	public WebElement PostalCode;

	@FindBy(id = "continue")
	public WebElement ContinueButton;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	public WebElement ItemTotal;
	
	@FindBy(xpath="//div[@class='summary_tax_label']")
	public WebElement Tax;
	
	

	public void sauceLabsBackPackAddToCart() {
		sauceBackPack.click();
	}

	public void sauceLabsFleeceJacketAddToCart() {
		sauceLabsJacket.click();

	}

	public void sauceLabsBoltTshirt() {
		saucelabsTshirt.click();
	}

	public void saucelabsOnesie() {
		sauceOnesie.click();
	}

	public void ShoppingCartBadge(int itemscount) {
		int ItemscountFromCart = Integer.parseInt(ShoppingBadge.getText());
		System.out.println("number of items in cart:" + ItemscountFromCart);
		Assert.assertEquals(ItemscountFromCart, itemscount);
	}

	public void ClickOncart() {
		cartLink.click();
	}

	public void ValidateQTYCountInCart(int QTYcount) {
		 QTYShirtCount = Integer.parseInt(QTYShirt.getText());
		System.out.println("Shirt quantity is : " + QTYShirtCount);
		Assert.assertEquals(QTYShirtCount, QTYcount);

		 QTYJacketCount = Integer.parseInt(QTYJacket.getText());
		System.out.println("jacket Quantity is :" + QTYJacketCount);
		Assert.assertEquals(QTYJacketCount, QTYcount);

		 QTYOneSieCount = Integer.parseInt(QTYOneSie.getText());
		System.out.println("OneSie Quantity is :" + QTYOneSieCount);
		Assert.assertEquals(QTYOneSieCount, QTYcount);

		 QTYBackPackCount = Integer.parseInt(QTYBackPack.getText());
		System.out.println("BackPack Quantity is :" + QTYBackPackCount);
		Assert.assertEquals(QTYBackPackCount, QTYcount);

	}

	public void RemoveJacketFromCart(DataTable datable) {
		List<String> items = datable.asList();
		for(String item:items) {
			RemoveItemsFromCart(item).click();
		}
	}

	public void ItemsCountAfterRemovingJacket(int ItemsCountAfterRemovingJacket) {
		int ItemscountFromCart = Integer.parseInt(ShoppingBadge.getText());
		System.out.println("number of items in cart:" + ItemscountFromCart);
		Assert.assertEquals(ItemscountFromCart, ItemsCountAfterRemovingJacket);
	}

	public void ClickOnCheckBox()

	{
		CheckOutButton.click();
	}

	public void EnterFirstNameInTextField(String Fname) {

		FirstName.sendKeys(Fname);
	}

	public void EnterlastNameInTextField(String Lname) {
		LastName.sendKeys(Lname);
	}

	public void EnterPostalCode(String zipcode) {
		PostalCode.sendKeys(zipcode);
	}

	public void ClickOnContinueButton() {
		ContinueButton.click();
	}

	
	public void TotalItemsInCheckoutPage()
	{
		int totalItemsInCheckout = QTYShirtCount+QTYOneSieCount+QTYBackPackCount;
		System.out.println("Total items in checkout page :"+totalItemsInCheckout);
		int ItemscountFromCart = Integer.parseInt(ShoppingBadge.getText());
		Assert.assertEquals(totalItemsInCheckout, ItemscountFromCart);
	}
	
	public void TaxRateAppliedToTotal()
	{
		String totalRate=ItemTotal.getText().replaceAll("[^0-9.]", "");
		float totalPrice = Float.parseFloat(totalRate);
		System.out.println("Total price:"+totalPrice);
		float percentageAmount = (totalPrice * 8) / 100;
		 BigDecimal roundedValueOfPercentageAmount = new BigDecimal(percentageAmount)
                 .setScale(2, RoundingMode.HALF_UP);
		float floatValueOfPercentageAmount = roundedValueOfPercentageAmount.floatValue();
		String taxRate=Tax.getText().replaceAll("[^0-9.]", "");
		float taxRateof8Percent = Float.parseFloat(taxRate);
		System.out.println("Total rate of tax:"+taxRateof8Percent);
		Assert.assertEquals(taxRateof8Percent, floatValueOfPercentageAmount);
		
	}
	
	
	
}
